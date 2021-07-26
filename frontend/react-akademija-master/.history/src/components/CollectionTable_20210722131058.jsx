import React from 'react'

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
