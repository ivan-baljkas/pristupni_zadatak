import React, {useState, useEffect} from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";

const App = () => {

  const [state, setState]= useState({
      proizvodi:[],
      currentPage:1,
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


const handlePrevious = (event) => {
  event.preventDefault();
  const newPage = state.currentPage - 1;
  
  setState({...state, currentPage:newPage})

  
};

const handleNext = (event) => {
  event.preventDefault();
  const newPage = state.currentPage + 1;
  
  setState({...state, currentPage:newPage})
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
          <TableItem id={proizvod.id} {...proizvod}/>
        ))}
        </CollectionTable>
    </div>
  );
};

export default App;
