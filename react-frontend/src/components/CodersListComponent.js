// CodersListComponent.js
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import CoderService from '../services/CoderService';
import Pagination from './Pagination';
import './css/CoderComponent.css';

function CodersListComponent() {
  const [coders, setCoders] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalRecords, setTotalRecords] = useState(0);
  const ITEMS_PER_PAGE = 10; // Adjust as needed

  useEffect(() => {
    fetchData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [currentPage]);

  const fetchData = async () => {
    try {
      const response = await CoderService.getAllCoders(currentPage - 1, ITEMS_PER_PAGE);
      const data = response.data;

      if (data.success) {
        setCoders(data.coder);
        setTotalRecords(data.totalRecords);
      }
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  const deleteCoder = async (coderId) => {
    try {
      await CoderService.deleteCoder(coderId);
      alert('Coder deleted successfully !!');
      fetchData();
    } catch (error) {
      console.error('Error deleting coder:', error);
    }
  };

  return (
    <div className="container" style={{ marginTop: '5%' }}>
      <h2 className="text-center">List of Coders</h2>
      <table className="table table-bordered table-striped">
        <thead>
          <tr style={{ textAlign: 'center' }}>
            <th>Coders Id</th>
            <th>Coders First Name</th>
            <th>Coders Last Name</th>
            <th>Coders Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {coders.map((coder) => (
            <tr key={coder.id} style={{ textAlign: 'center' }}>
              <td>{coder.id}</td>
              <td>{coder.firstName}</td>
              <td>{coder.lastName}</td>
              <td>{coder.emailId}</td>
              <td>
                <Link className="btn btn-secondary" to={`/edit-coder/${coder.id}`}>
                  Update
                </Link>
                <button
                  style={{ marginLeft: '20px' }}
                  className="btn btn-secondary"
                  onClick={() => deleteCoder(coder.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="text-center">
        <Pagination
          totalItems={totalRecords}
          itemsPerPage={ITEMS_PER_PAGE}
          currentPage={currentPage}
          onPageChange={handlePageChange}
        />
      </div>
    </div>
  );
}

export default CodersListComponent;
