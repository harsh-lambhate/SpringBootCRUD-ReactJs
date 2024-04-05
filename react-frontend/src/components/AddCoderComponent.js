import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import CoderService from '../services/CoderService';


function AddCoderComponent() {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [emailId, setEmailId] = useState('');
  const navigate = useNavigate();
  const { id } = useParams();


  const title = () => {
    if (id) {
      return <h2 className='text-center'>Update Coders</h2>
    }
    else {
      return <h2 className='text-center'>Add Coder</h2>
    }

  }
  
  const saveOrUpdate = (e) => {

    e.preventDefault();

    const coder={firstName,lastName,emailId}

    if (id) {
      console.log("Update Coder")
      CoderService.updateCoder(id,coder).then((response)=>{
        alert('Data Save Successfully !!')
        navigate('/coders')
      }).catch((error)=>{
        console.log(error);
      })


    }
    else {
      console.log("Create Coder")
      CoderService.createCoder(coder).then((response) => {
        console.log(response.data)
        alert('Coder created successfully !!')
        navigate('/coders')
      }
      ).catch((error) => {
        console.log(error)
      })

    }
  }




  useEffect(() => {
    if(id!==undefined)
    {
      CoderService.getCoderById(id).then((response) => {
        setFirstName(response.data.firstName)
        setLastName(response.data.lastName)
        setEmailId(response.data.emailId)
        console.log(response.data)
      }).catch((error) => {
        console.log('inside error getCoderById()')
        console.log(error)
      })
    }
  },[id])


  return (
    <div>
      <div className="container" style={{ marginTop: '5%' }}>
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3" style={{"marginTop":"5%"}}>
            {
              title()
            }
            <div className="card-body" >
              <form>
                <div className="form-group mb-2">
                  <label className="form-label"> First Name :</label>
                  <input
                    type="text"
                    placeholder="Enter first name"
                    name="firstName"
                    className="form-control"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                  >
                  </input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Last Name :</label>
                  <input
                    type="text"
                    placeholder="Enter last name"
                    name="lastName"
                    className="form-control"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                  >
                  </input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Email Id :</label>
                  <input
                    type="email"
                    placeholder="Enter email Id"
                    name="emailId"
                    className="form-control"
                    value={emailId}
                    onChange={(e) => setEmailId(e.target.value)}
                  >
                  </input>
                </div>
                <div style={{ "textAlign": "center" }}>
                  <button className="btn btn-success" onClick={(e) => saveOrUpdate(e)} >Submit </button>
                  <Link style={{ "marginLeft": "10px" }} to="/coders" className="btn btn-danger"> Cancel </Link>
                </div>
              </form>

            </div>
          </div>
        </div>

      </div>

    </div>
  )
}


export default AddCoderComponent