import React from 'react'

export const CollectionTable = (props) =>{

    return(
        <div>
            <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Cijena</th>
                    <th>Količina</th>
                    <th>Brand</th> 
                </tr>
            </thead>
             <tbody>
                {props.children}
            </tbody>

            </table>
        </div>
    );
};
