import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <div>
                <label htmlFor="query">Query </label>
                <input type="text" id="query"/>
            </div>
            
            
            <button type="button">Search</button>

            <p>{props.children}</p>
        </div>
    );
};
