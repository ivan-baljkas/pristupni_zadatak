import React, {useState, useEffect} from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";
import { TableItem2 } from "./components/TableItem2";
import { CollectionTable2 } from "./components/CollectionTable2";
import { NarudzbaForm } from "./components/NarudzbaForm";
import { Message } from "./components/Message";


const App = () => {

  const [state, setState]= useState({
      proizvodi:[],
      odabraniProizvodi:[],
      naciniPlacanja:[],
      kodovi:[],
      brandovi: [],
      narudzbaId: 1,
      ukupnaCijena:0,
      uvjetMessage: false
  });

  const[formState, setFormState] = useState({
      brand:'',
      naziv:'',
      cijena:0,
      kodZaPopust:'',
      brojKartice:'',
      email:'',
      brojMobitela:'',
      adresaDostave:'',
      napomena:'',
      placanje:'KARTIČNO'
  });


  /* Dohvaćanje proizvoda */
useEffect(() => {
  fetch(`http://localhost:8080/api/proizvod`)
    .then((data) => data.json())
    .then((data) => {
      console.log(data)
      setState({...state, proizvodi:data})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });

    /*Dohvaćanje brandova*/ 
    fetch(`http://localhost:8080/api/brand`)
    .then((data) => data.json())
    .then((data) => {
      console.log(data)
      setState({...state, brandovi:data})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });

     /*Dohvaćanje Nacina placanja*/ 
    fetch(`http://localhost:8080/api/nacin-placanja`)
        .then((data) => data.json())
        .then((data) => {
          console.log(data)
          setState({...state, naciniPlacanja:data})
        })
        .catch((error)=>{
            console.log('Error: ',error);
        });

     /*Dohvaćanje neiskoristenih Popust kodova*/ 
    fetch(`http://localhost:8080/api/popust-kodovi?iskoristen=false`)
    .then((data) => data.json())
    .then((data) => {
      console.log(data)
      setState({...state, kodovi:data})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });
},[]);

// za filtriranje
const handleSearch = (event) => {
  event.preventDefault();

  let helpBrand = formState.brand.length > 0 ? formState.brand: 'null';
  let helpNaziv = formState.naziv.length > 0 ? formState.naziv: 'null';
  let helpCijena = (formState.cijena.length >0) ? formState.cijena : 0;

  console.log('brand: ', helpBrand)
  console.log('naziv: ', helpNaziv)
  console.log('cijena: ', helpCijena)

  let apiUrl = `http://localhost:8080/api/proizvod?brand=${helpBrand}&naziv=${helpNaziv}&cijena=${helpCijena}`;

  fetch(apiUrl)
    .then((data) => data.json())
    .then((data) => {
      console.log(data)
      setState({...state, proizvodi:data})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });
  

};

// za svaku promjenu u unosu filtera i detalja narudzbe
const handleChange = (event) => {
  const value = event.currentTarget.value;
  setFormState({ ...formState, [event.target.name]: value });

  console.log(event.target.name,":",event.currentTarget.value)
  };



  // za dodavanje proizvoda u košaricu
const handleDodajProizvod = (proizvodId) => {

  const data = { narudzbaId: state.narudzbaId, proizvodId: proizvodId };


  fetch('http://localhost:8080/api/narudzba-proizvod', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
        console.log('Success:', data);
          })
      .catch((error) => {
      console.error('Error:', error);
        });

  
  let newProizvodi = state.proizvodi;
  newProizvodi.forEach(p=>{
    if(p.id === proizvodId){
        p.kolicina=p.kolicina-1;
    }
  });


  fetch(`http://localhost:8080/api/proizvod/${proizvodId}`)
  .then((data) => data.json())
  .then((data) => {
    const newUkupnaCijena = state.ukupnaCijena + data.cijena;
    setState({...state,
                proizvodi:newProizvodi.filter(p=> p.kolicina>0),
               odabraniProizvodi:[...state.odabraniProizvodi, data],
               ukupnaCijena: newUkupnaCijena
              });
               
  })
  .catch((error)=>{
      console.log('Error: ',error);
  });

};



// za uklanjanje proizvoda iz košarice
const handleUkloniProizvod = (proizvodId) => {

  fetch(`http://localhost:8080/api/narudzba-proizvod/${state.narudzbaId}/${proizvodId}`, 
  { method: 'DELETE' })

  let newProizvodi = state.proizvodi;
  newProizvodi.forEach(p=>{
    if(p.id === proizvodId){
        p.kolicina=p.kolicina+1;
    }
  });

  let proizvodZaIzbaciti;
  let newodabraniProizvodi = state.odabraniProizvodi;
  newodabraniProizvodi.forEach(p=>{
    if(p.id === proizvodId){
        proizvodZaIzbaciti = p;
    }
  })

  const index = newodabraniProizvodi.indexOf(proizvodZaIzbaciti);
  newodabraniProizvodi.splice(index, 1)

  const newUkupnaCijena = state.ukupnaCijena - proizvodZaIzbaciti.cijena;

  setState({...state,
    odabraniProizvodi:newodabraniProizvodi,
    ukupnaCijena:newUkupnaCijena
   });

};


  // za stvaranje narudzbe
  const handleStvoriNarudzbu = (event) => {
    event.preventDefault();
    var today = new Date();
    var month= today.getMonth()+1 < 10? "0"+(today.getMonth()+1): (today.getMonth()+1);
    var date = today.getFullYear()+'-'+month+'-'+today.getDate();

    let helpNacinPlacanjaId = 1;
    state.naciniPlacanja.forEach(np=>{
      if(np.naziv === formState.placanje){
        helpNacinPlacanjaId=np.id
      }});

    let helpKodId = 0;
    state.kodovi.forEach(kod=>{
      if(kod.kod === formState.kodZaPopust){
        helpKodId=kod.id
      }
    });

    const data =  {
      datum: date,
      ukupnaCijenaBezP: state.ukupnaCijena,
      ukupnaCijenaSP: 0.0,
      kodZaPopustId: helpKodId,
      nacinPlacanjaId: helpNacinPlacanjaId,
      brojKartice: formState.brojKartice,
      email: formState.email,
      brojMobitela: parseInt(formState.brojMobitela),
      adresaDostave: formState.adresaDostave,
      napomena: formState.napomena
    } 

    console.log(data)

    fetch('http://localhost:8080/api/narudzba', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
        console.log('Success:', data);
        const newNarudzbaId = state.narudzbaId + 1;
        setState({...state,
          narudzbaId: newNarudzbaId
        });
          })
      .catch((error) => {
      console.error('Error:', error);
        });


  
  };

  return (
    <div>
      <header>
        <h1>
          Proizvodi
        </h1>  
      </header>
      <SearchForm state={state}  handleSearch={handleSearch} handleChange={handleChange}/>
        <CollectionTable>
        {state.proizvodi.map(proizvod=>(
          <TableItem id={proizvod.id} {...proizvod} brandovi={state.brandovi} handleDodajProizvod={handleDodajProizvod}/>
        ))}
        </CollectionTable>
        <h1>
          Košarica
        </h1>
        <CollectionTable2>
        {state.odabraniProizvodi.map(proizvod=>(
          <TableItem2 id={proizvod.id} {...proizvod} brandovi={state.brandovi} handleUkloniProizvod={handleUkloniProizvod}/>
        ))}
        </CollectionTable2>
        <h1>
          Detalji narudžbe
        </h1>
        <NarudzbaForm ukupnaCijena={state.ukupnaCijena} naciniPlacanja={state.naciniPlacanja} handleChange={handleChange}
                      handleStvoriNarudzbu={handleStvoriNarudzbu}/>
        <Message uvjetMessage={state.uvjetMessage}/>
    </div>
  );
};

export default App;
