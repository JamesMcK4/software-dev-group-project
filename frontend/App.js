import React from 'react';
import logo from './logo.svg';
import './App.css';
import ButtonGroup from '@material-ui/core/ButtonGroup'
import Button from '@material-ui/core/Button'
import SaveIcon from '@material-ui/icons/Save'
import DeleteIcon from '@material-ui/icons/Delete'
import Checkbox from '@material-ui/core/Checkbox'
import FormControlLabel from '@material-ui/core/FormControlLabel'
import TextField from '@material-ui/core/TextField'
import {makeStyles} from '@material-ui/core/styles'




const useStyle = makeStyles ({
  root: {
    background: 'radial-gradient(45deg, #333, #000)',
    border: 0,
    borderRadius: 15,
    color: 'white',
    padding: '0 30px'
  }
})

function ButtonStyled(){
  const classes = useStyle();
  return <Button classname = {classes.root}>Test Style Button</Button>
}

function CheckboxExample(){
  const [checked, setChecked] = React.useState(true)
  return (
    <FormControlLabel 
      control={<Checkbox 
        checked={checked}
        onChange={(e)=>setChecked(e.target.checked)}
        inputProps={{
          'aria-label': 'secondary checkbox'
        }}
      />}
      label="Stay signed in"
    />
      
      
  )
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <ButtonStyled/>
      <TextField 
        variant="filled"
        color="secondary"
        type="Username"
        label="Your Username: "
        placeholder="Username"
        />
        <TextField 
        variant="filled"
        color="secondary"
        type="Password"
        label="Your Password: "
        placeholder="***********"
        />
        <TextField 
        variant="filled"
        color="secondary"
        type="Email"
        label="Your Email: "
        placeholder="Test@test.com"
        />
        <CheckboxExample/>
        <ButtonGroup variant='contained' >
          <Button
        startIcon={<SaveIcon />}
        color="primary">
          Save
        </Button>
        <Button
        startIcon={<DeleteIcon />} 
        color="secondary">
          Delete
        </Button>
        </ButtonGroup>
        <img src={logo} className="App-logo" alt="logo" /> 
      </header>
    </div>
  );
}

export default App;
