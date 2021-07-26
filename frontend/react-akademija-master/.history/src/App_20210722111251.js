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
      searchQuery:''
  });

  const [queryResult, setQueryResult]= useState('');


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
}, []);

const handleSearch = () => {
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

  return (
    <div>
      <header>
        Collection
      </header>
      <SearchForm state>
          {queryResult}
        </SearchForm>
        <CollectionTable>
        {state.results.map(release=>(
          <TableItem id={release.id} {...release}/>
        ))}
        </CollectionTable>
        <Pagination currentPage={1} pages={2} />
    </div>
  );
};

export default App;
