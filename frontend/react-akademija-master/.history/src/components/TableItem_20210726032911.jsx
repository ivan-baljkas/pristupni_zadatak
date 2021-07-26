import React from 'react'

export const TableItem = (props) =>{

    return(
                <tr>
                    <td>{props.id}</td>
                    <td>{props.naziv}</td>
                    <td>{props.opis}</td>
                    <td>{props.cijena}</td>
                    <td>{props.kolicina}</td>
                    <td>{props.brandovi.filter(brand=> brand.id === props.brandId).map(brand=>brand.naziv)}</td> 
                </tr>
    );
};
