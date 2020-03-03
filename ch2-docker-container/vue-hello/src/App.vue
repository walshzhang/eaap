<template>
  <div id="app">
    <div id="sender">
      <input type="text" v-model="name" />
      <button @click="send">发送</button>
    </div>
    <div id="greeting">
      <p style="margin-bottom: 0;">Vue: {{ name }}</p>
      <p style="margin-top: 0;">Spring: {{ greeting }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      name: "",
      greeting: ""
    };
  },
  methods: {
    send() { // Axios Promise
      fetch(`http://localhost:8000/hello/${this.name}`)
        .then(response => {
          return response.text();
        })
        .then(text => (this.greeting = text))
        .catch(error => console.log(error));
    }
  }
};
</script>