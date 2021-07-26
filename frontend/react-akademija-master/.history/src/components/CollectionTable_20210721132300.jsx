import React, { Component } from 'react'
import { TableItem } from './TableItem';
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
                {props.children}

            </table>

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

            </tbody>

            </table>
        </div>
    );
};
