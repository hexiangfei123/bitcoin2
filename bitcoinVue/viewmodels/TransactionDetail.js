var app = new Vue({
    el: '#app',
    data: {
         txhash:"",
         transaction:{},
    },
    methods:{
        getByTransactionHash() {
            axios.get("http://localhost:8080/transaction/getByTxid?txhash=" + this.txhash).then(res => {
                console.log(res);
               this.transaction = res.data;
                console.log(this.transaction);
             
            })
        },


    },
    mounted(){
        var url = new URL(location.href);
        this.txhash = url.searchParams.get("txhash");
        console.log(this.txhash);
        this.getByTransactionHash();

    }
})