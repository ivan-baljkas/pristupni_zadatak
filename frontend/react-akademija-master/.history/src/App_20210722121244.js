import React, {useState, useEffect} from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";
import { Pagination } from "./components/Pagination";
//import data from "./data.json";


const App = () => {

  const [state, setState]= useState({
      results:[],
      currentPage:1,
      searchQuery:'',
      pages:6
  });

  const [queryResult, setQueryResult]= useState('No results');


  /* Dohvaćanje kolekcije */
useEffect(() => {
  fetch(`https://api.discogs.com/users/adrianmusiccollector/collection/folders/0/releases?page=${state.currentPage}`)
    /* Dohvaćanje API URL-a sa prosljeđenom paginacijom */
    .then((data) => data.json())
    .then((data) => {
      /* Dopuniti sa state update funkcijom */
      const items = data.releases
      setState({...state, results:items})
    })
    .catch((error)=>{
        console.log('Error: ',error);
    });
}, [state.currentPage]);

const handleSearch = (event) => {
  
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


const handlePrevious = (event) => {

  const newPage = state.currentPage - 1;
  
  setState({...state, currentPage:newPage})
};

const handleNext = (event) => {

  const newPage = state.currentPage + 1;
  
  setState({...state, currentPage:newPage})
};


  

  return (
    <div>
      <header>
        Collection
      </header>
      <SearchForm state={state} queryState={[queryResult, setQueryResult]} handleSearch={handleSearch} >
          {queryResult}
        </SearchForm>
        <CollectionTable>
        {state.results.map(release=>(
          <TableItem id={release.id} {...release}/>
        ))}
        </CollectionTable>
        <Pagination currentPage={state.currentPage} pages={6} />
    </div>
  );
};

export default App;
