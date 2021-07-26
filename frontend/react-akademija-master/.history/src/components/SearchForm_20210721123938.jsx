import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <button type="button">Query</button>
            <label for="fname">Query:</label>
            <input type="text" id="fname" name="fname"/>
        </div>
    );
};
