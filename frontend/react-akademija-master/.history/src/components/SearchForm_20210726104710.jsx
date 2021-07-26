import React from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <form  onClick={props.handleSearch}>
            <div>
                
                <label htmlFor="query">Brand</label>
                <input type="text" id="brand" name="query" onChange={props.handleQueryChange}/>
                <button type="submit">Search</button>
                
            </div>
            <div>
            <   label htmlFor="query">Naziv</label>
                <input type="text" id="query" name="query" onChange={props.handleQueryChange}/>
                <button type="submit">Search</button>
            </div>
            <div>
                <label htmlFor="query">Cijena</label>
                <input type="number" id="query" name="query" onChange={props.handleQueryChange}/> 
                <button type="submit">Search</button>
            </div>   

            </form>   
            
        </div>
    );
};
