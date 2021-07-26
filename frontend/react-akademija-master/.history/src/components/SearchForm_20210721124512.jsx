import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <div>
                <label htmlFor="query">Query </label>
                <input type="text" id="query"/>
            </div>
            
            <br></br>
            <button type="button">Search</button>
        </div>
    );
};
