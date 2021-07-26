import React from 'react'

export const TableItem = (props) =>{

    return(
                <tr>
                    <td>{props.id}</td>
                    <td>{props.basic_information.artists.map(({name})=> name).join(", ")}</td>
                    <td>{props.basic_information.title}</td>
                    {props.basic_information.year?<td>{props.basic_information.year}</td>:
                   <td>N/A</td> } 
                    <td>{props.basic_information.genres.join(", ")}</td>
                    <td>{props.basic_information.styles.join(", ")}</td> 
                </tr>
    );
};
