import React from 'react'

export const NarudzbaForm = (props) =>{

    return(
        <div>
            <form className="container" onClick={props.handleStvoriNarudzbu}>

            <div>
                
                <label htmlFor="query">Ukupna cijena</label>
                <input type="number" id="ukupnaCijena" name="ukupnaCijena" disabled={true} value={props.ukupnaCijena}/>
                
            </div>
            <div>
                
                <label htmlFor="query">Kod za popust</label>
                <input type="text" id="kodZaPopust" name="kodZaPopust" onChange={props.handleChange}/>
                
            </div>
            <div>
                <label for="placanje">Odaberi način plaćanja:</label>
                <select name="placanje" id="placanje" onChange={props.handleChange}>
                    {props.naciniPlacanja.map(np=>
                        <option value="np.naziv">np.naziv</option>
                    )        
                    }
                </select>
            </div>
            <div>
                
                <label htmlFor="query">Broj kartice</label>
                <input type="text" id="brojKartice" name="brojKartice" onChange={props.handleChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Email</label>
                <input type="email" id="email" name="email" onChange={props.handleChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Broj mobitela</label>
                <input type="text" id="brojMobitela" name="brojMobitela" onChange={props.handleChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Adresa dostave</label>
                <input type="text" id="adresaDostave" name="adresaDostave" onChange={props.handleChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Napomena</label>
                <input type="text" id="napomena" name="napomena" onChange={props.handleChange}/>
                
            </div> 
            <div>
                <button type="submit">Naruči</button>
            </div> 

            </form>   
            
        </div>
    );
};