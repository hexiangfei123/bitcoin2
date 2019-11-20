var app = new Vue({
    el: '#app',
    data: {
        blockhash: "",
        block: {},
        pagesize: 0,
        total: 0,
        page: 1,


    },
    methods: {
        getByblockHash() {
            axios.get("http://localhost:8080/blocks/getByblockHash?blockhash=" + this.blockhash + "&page="+this.page).then(res => {
                this.block = res.data;
                this.total = res.data.transactionDTOPageInfo.total;
                this.pagesize = res.data.transactionDTOPageInfo.pageSize;
                this.page = res.data.transactionDTOPageInfo.pageNum;
                console.log(res);
            })
        },
         handleSizeChange(val){
          this.pagesize=val;
          this.getByblockHash();

       },
       handleCurrentChange(val){
         this.page=val;
         this.getByblockHash();

       }
    },
    mounted() {
        console.log('view mounted');
        var url = new URL(location.href);
        this.blockhash = url.searchParams.get("blockhash");


      


        this.getByblockHash();
    },
})