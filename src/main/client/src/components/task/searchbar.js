import {Form, Button} from 'react-bootstrap';
import React from 'react';
import {Link} from 'react-router-dom'
import {Card, Row, Col} from 'react-bootstrap';
import { Board } from '../..';

function SearchBar({tasks, setTasks}){

   const searchTask = (e) => {

        const searchItem = e.target.value;
        console.log(searchItem);
        const searchForTask = tasks.filter(task => {
            if(task.name.toLowercase().includes(searchItem.toLowercase())){
                return task;
            }
        });

        console.log(searchForTask);
        setTasks(searchForTask);

   }


    return (
    <Form className="d-flex">
        <Form.Control
        type="search"
        placeholder="Search for a task using full task name"
        className="me-2"
        aria-label="Search"
        />
    <Button variant="outline-success" type="submit" onClick={searchTask}>Search</Button>
    </Form>
    );
    }
export default SearchBar;