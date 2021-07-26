import React, {useState, useEffect} from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";
import { TableItem2 } from "./components/TableItem2";
import { CollectionTable2 } from "./components/CollectionTable2";
import axios from 'axios';

const App = () => {

  const [state, setState]= useState({
      proizvodi:[],
      odabraniProizvodi:[],
      brandovi: [],
      searchQuery:'',
      brand:'',
      narudzbaId: 1
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

  const data = { narudzbaId: state.narudzbaId, proizvodId: proizvodId };



  fetch(`http://localhost:8080/api/proizvod/${proizvodId}`)
  .then((data) => data.json())
  .then((data) => {
    setState({...state,
               odabraniProizvodi:[...state.odabraniProizvodi, data]
              });
               
  })
  .catch((error)=>{
      console.log('Error: ',error);
  });
};


const handleUkloniProizvod = (proizvodId) => {

  fetch(`http://localhost:8080/api/proizvod/${proizvodId}`)
  .then((data) => data.json())
  .then((data) => {
    setState({...state,
               odabraniProizvodi:state.odabraniProizvodi.filter(proizvod=> proizvodId !== proizvod.id),
               proizvodi:[...state.proizvodi, data]
              });
               
  })
  .catch((error)=>{
      console.log('Error: ',error);
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
          Košarica
        </h1>
        <CollectionTable2>
        {state.odabraniProizvodi.map(proizvod=>(
          <TableItem2 id={proizvod.id} {...proizvod} brandovi={state.brandovi} handleUkloniProizvod={handleUkloniProizvod}/>
        ))}
        </CollectionTable2>
    </div>
  );
};

export default App;
