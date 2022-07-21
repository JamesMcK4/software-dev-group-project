import {Form, Button} from 'react-bootstrap';
import React from 'react';

function SearchBar({tasks, setTasks}){
   
   const searchTask = (e) => {
    e.preventDefault();
        const searchItem = e.target.search.value;
        console.log(searchItem);
        const searchForTask = tasks.filter(task => {
            if(task.name.toLowerCase().includes(searchItem.toLowerCase())){
                return task;
            }
        });

        console.log(searchForTask);
        setTasks(searchForTask);
   }


    return (
    <Form className="d-flex" onSubmit={searchTask}>
        <Form.Control
        type="search"
        placeholder="Enter some keywords to search for tasks"
        className="me-2"
        aria-label="Search"
        name = "search"
        />
    </Form>
    );
    }
export default SearchBar;