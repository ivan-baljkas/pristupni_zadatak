import React from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <form  onClick={props.handleSearch}>
            <div>
                
                <label htmlFor="query">Brand</label>
                <input type="text" id="query" name="query" onChange={props.handleQueryChange}/>

                <label htmlFor="query">Naziv</label>
                <input type="text" id="query" name="query" onChange={props.handleQueryChange}/>

                <label htmlFor="query">Cijena</label>
                <input type="text" id="query" name="query" onChange={props.handleQueryChange}/>
            </div>
            <div>
                <button type="submit">Search</button>
                <p class="result">{props.children}</p>
            </div>   

            </form>   
            
        </div>
    );
};
