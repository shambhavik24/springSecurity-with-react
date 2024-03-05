import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './RegisterPage.css';

const MasterApi = () => {

  const [petrolRate, setPetrolRate] = useState('');
  const [diselRate, setDiselRate] = useState('');
  const [companyName, setCompanyName] = useState('');
  const [companyList, setCompanyList] = useState(['']);

  useEffect(() =>{
     const fetchedCompanyList = ['company-A', 'company-B', 'company-C','company-D','company-E'];
     setCompanyList(fetchedCompanyList);
     },[]);

  const submitHandler =async (e) =>{
    e.preventDefault();

    try{
      const response = await axios.post('http://localhost:8083/api',{
        companyName,
        petrolRate,
        diselRate
      });
      console.log(" Data added sucessfully",response)
      alert(" Data added sucessfully");
    }
    catch(error){
      console.log("falied to add Rates",error)
    }
    if(error.response){
      console.log('Response data', error.response.data);
      console.log('Response status',error.response.status);
      console.log('Response header', error.response.header);
    }else if(error.request){
      console.log('No response recevied', error.request);
    }else{
      console.log('Something else')
    }
  };

  return (
    <div className="rate-form">
  <form className='master-form' onSubmit={submitHandler}>
    <h1>Fuel Rate</h1>

    <div className="form-group">
          <label htmlFor='companyName'>Company Name</label>
          <select
            id='companyName'
            value={companyName}
            onChange={(e) => setCompanyName(e.target.value)}
            required
          >
            <option value='' disabled>Select a company</option>
            {companyList.map((company, index) => (
              <option key={index} value={company}>
                {company}
              </option>
            ))}
          </select>
        </div>
   
     
     <div className="form-group">
      <label htmlFor='petrolRate'>Petrol-Rate</label>
      <input
      type='float'
      id='petrolrate'
      placeholder='Enter a petrol rate'
      value={petrolRate}
      onChange={(e) => setPetrolRate(e.target.value)}
      required
       />
     </div>

     <div className="form-group">
      <label htmlFor='diselRate'>Diesel-Rate</label>
      <input
      type='float'
      id='dieselrate'
     placeholder='Enter a diesel rate'
      value={diselRate}
      onChange={(e) => setDiselRate(e.target.value)}
      required
      />
     </div>


     <button type='submit'>Add Rate</button>
  </form>
  </div>
  )
}

export default MasterApi
