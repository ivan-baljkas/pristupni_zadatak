import React from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";
import { Pagination } from "./components/Pagination";
//import data from "./data.json";

const apiURL ='https://api.discogs.com/database/search?q=${query}&key=OxnCHJEetGbikaamOyaK&secret=wQCIuWuanmRVVeWqNVFWMfSJldHbqnAi'

const App = () => {
  console.log(data);

  return (
    <div>
      <header>
        Collection
      </header>
      <SearchForm>
          No results
        </SearchForm>
        <CollectionTable>
        {data.releases.map(release=>(
          <TableItem id={release.id} {...release}/>
        ))}
        </CollectionTable>
        <Pagination currentPage={1} pages={2} />
    </div>
  );
};

export default App;
