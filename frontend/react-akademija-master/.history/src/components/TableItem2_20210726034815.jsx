import React from 'react'

export const TableItem = (props) =>{

    return(
                <tr>
                    <td>{props.id}</td>
                    <td>{props.naziv}</td>
                    <td>{props.opis}</td>
                    <td>{props.cijena}</td>
                    <td>{props.kolicina}</td>
                    <td>{props.brand}</td> 
                    <td><button type="submit" onClick={()=>props.handleUkloniProizvod(props.id)}>Ukloni</button></td>
                </tr>
    );
};
