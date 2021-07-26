import React, { Component } from 'react'

export const TableItem = (props) =>{

    return(
                <tr>
                    <th>{props.id}</th>
                    <th>{props.basic_information.artists[0].name}</th>
                    <th>{props.basic_information.title}</th>
                    <th>{props.basic_information.year}</th>
                    <th>{props.basic_information.genres}</th>
                    <th>{props.styles}</th> 
                </tr>
    );
};
