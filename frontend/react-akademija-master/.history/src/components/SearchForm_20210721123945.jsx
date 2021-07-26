import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <label for="fname">Query:</label>
            <input type="text" id="fname" name="fname"/>
            <button type="button">Query</button>
        </div>
    );
};
