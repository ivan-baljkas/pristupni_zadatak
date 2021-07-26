import React from "react";
import { SearchForm } from "./components/SearchForm";
import { CollectionTable } from "./components/CollectionTable";
import { TableItem } from "./components/TableItem";
import { Pagination } from "./components/Pagination";
import data from "./data.json";

const App = () => {
  console.log(data);

  return (
    <div>
      <header>
        Nesto
      </header>
      <SearchForm>
          No results
        </SearchForm>

        {data.releases.map(release=>(
          <TableItem id={release.id}/>
        ))}
        <Pagination />
    </div>
  );
};

export default App;
