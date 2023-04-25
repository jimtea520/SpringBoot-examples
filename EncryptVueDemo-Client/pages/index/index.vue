<template>
  <div>
    <h1>Login Page</h1>
    <form>
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username">
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password">
      <br>
      <button type="submit" @click.prevent="login">Login</button>
    </form>
  </div>
</template>

<script>
import { reactive } from 'vue';
import {Encrypt} from '../utils/Secret.js'

export default {
  data: function() {
	return {
	  username: '',
	  password: ''
	}
  },
  methods: {
	login: function() {
	  let userName = this.username;
	  let pword = this.password;
	  console.log("userName:"+userName+"password1:"+pword);
	  pword = Encrypt(pword);
	  console.log("password2:"+pword);
	  
	  fetch('http://localhost:8100/api/demo/login', {
	    method: 'POST',
	    headers: {
	      'Content-Type': 'application/json'
	    },
	    body: JSON.stringify({
	      userName: userName,
	      passward: pword
	    })
	  })
	  .then(response => response.json())
	  .then(data => console.log(data))
	  .catch(error => console.error(error));
	}
  }
};
</script>
