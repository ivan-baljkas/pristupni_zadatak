import React, { Component } from 'react'
import { TableItem } from './TableItem';
export const CollectionTable = (props) =>{

    return(
        <div>
            <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Artists</th>
                    <th>Title</th>
                    <th>Year</th>
                    <th>Genre</th>
                    <th>Styles</th> 
                </tr>
            </thead>
             <tbody>
                {props.children}
            </tbody>

            </table>
        </div>
    );
};
