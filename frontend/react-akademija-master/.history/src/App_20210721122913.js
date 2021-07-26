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
        <SearchForm/>
        <CollectionTable/>
        {data.data}
        <TableItem/>
        <Pagination/>
    </div>
  );
};

export default App;
