import {Form, Button} from 'react-bootstrap';
import React from 'react';
import {Link} from 'react-router-dom'
import {Card, Row, Col} from 'react-bootstrap';
import { Board } from '../..';

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
        placeholder="Search for a task using full task name"
        className="me-2"
        aria-label="Search"
        name = 'search'
        />
    <Button variant="outline-success" type="submit" >Search</Button>
    </Form>
    );
    }
export default SearchBar;