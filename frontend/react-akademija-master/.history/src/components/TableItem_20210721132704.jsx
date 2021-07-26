import React, { Component } from 'react'

export const TableItem = (props) =>{

    return(
                <tr>
                    <th>{props.id}</th>
                    <th>{props.artists}</th>
                    <th>{props.title}</th>
                    <th>{props.year}</th>
                    <th>{props.genre}</th>
                    <th>{props.styles}</th> 
                </tr>
    );
};
