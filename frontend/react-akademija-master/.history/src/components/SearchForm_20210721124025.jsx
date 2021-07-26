import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <label for="fname">Query </label>
            <input type="text" id="fname" name="fname"/>
            <br></br>
            <button type="button">Search</button>
        </div>
    );
};
