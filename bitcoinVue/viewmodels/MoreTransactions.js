var app = new Vue({
    el: '#app',
    data: {
        unconfirmedTransactions:[],
    },
    methods:{
        getunconfirmedTransactions(){
            axios.get("http://localhost:8080/transaction/getRecentUnconfirmed").then(res=>{
                console.log(res);
                this.unconfirmedTransactions=res.data;
            })
           }
    },
    mounted(){
      this.getunconfirmedTransactions();
    }
})