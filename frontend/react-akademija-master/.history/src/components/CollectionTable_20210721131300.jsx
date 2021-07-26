import React, { Component } from 'react'
import { TableItem } from './TableItem';
import data from "src/data.json";

export const CollectionTable = (props) =>{

    return(
        <div>
            <table styles="width:100%">
                <tr>
                    <th>id</th>
                    <th>Artists</th>
                    <th>Title</th>
                    <th>Year</th>
                    <th>Genre</th>
                    <th>Styles</th> 
                </tr>
                {data.releases.map(release=>(
          <TableItem id={release.id}/>
        ))}
            </table>
        </div>
    );
};
