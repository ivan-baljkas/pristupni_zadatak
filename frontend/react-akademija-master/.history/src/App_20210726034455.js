import React, {useState, useEffect} from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";

const App = () => {

  const [state, setState]= useState({
      proizvodi:[],
      odabraniProizvodi:[],
      brandovi: [],
      searchQuery:'',
      brand:''
  });

  const [queryResult, setQueryResult]= useState('No results');


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

    fetch(`http://localhost:8080/api/brand`)
    .then((data) => data.json())
    .then((data) => {
      console.log(data)
      setState({...state, brandovi:data})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });
}, []);

const handleSearch = (event) => {
  event.preventDefault();
  fetch(
    `https://api.discogs.com/database/search?q=${state.searchQuery}&key=OxnCHJEetGbikaamOyaK&secret=wQCIuWuanmRVVeWqNVFWMfSJldHbqnAi`
  )
    .then((data) => data.json())
    .then((data) => {
      setQueryResult(
        Boolean(data.results.length) ? data.results[0].title : "No results"
      );
    });
};

const handleQueryChange = (event) => {
  const value = event.currentTarget.value;
  setState({ ...state, searchQuery: value });
  };


const handleDodajProizvod = (proizvodId) => {

  fetch(`http://localhost:8080/api/proizvod/${proizvodId}`)
  .then((data) => data.json())
  .then((data) => {
    console.log(data)
    setState({...state,
               proizvodi:state.proizvodi.filter(proizvod=> proizvodId !== proizvod.id),
               odabraniProizvodi:[...state.proizvodi, data]
              });
               
  })
  .catch((error)=>{
      console.log('Error: ',error);
  });


  axios.get(`https://tecajevi-i-lekcije.herokuapp.com/customers/${rowId}`)
  .then(response => {
      setFormState(formState => ({
          ...formState,
          customers:formState.customers.filter(customer=>customer.id!==rowId),
          customers2:[...formState.customers2,response.data],
          values: {
              ...formState.values,
              membersId:[...formState.values.membersId, rowId]
          }
      }));       
});
};


  

  return (
    <div>
      <header>
        <h1>
          Proizvodi
        </h1>  
      </header>
      <SearchForm state={state}  handleSearch={handleSearch} handleQueryChange={handleQueryChange}>
          {queryResult}
        </SearchForm>
        <CollectionTable>
        {state.proizvodi.map(proizvod=>(
          <TableItem id={proizvod.id} {...proizvod} brandovi={state.brandovi} handleDodajProizvod={handleDodajProizvod}/>
        ))}
        </CollectionTable>
        <h1>
          Odabrani Proizvodi
        </h1>
        <CollectionTable>
        {state.odabraniProizvodi.map(proizvod=>(
          <TableItem id={proizvod.id} {...proizvod} brandovi={state.brandovi} handleDodajProizvod={handleDodajProizvod}/>
        ))}
        </CollectionTable>
    </div>
  );
};

export default App;
