var app = new Vue({
    el: '#app',
    data: {
         address:"",
         addressDTO:{},
         pagesize: 0,
         total: 0,
         page: 1,


    },
    methods:{
        handleSizeChange(val){
            this.pagesize=val;
            this.getaddress();
  
         },
         handleCurrentChange(val){
           this.page=val;
           this.getaddress();
  
         },
         getaddress(){
               axios.get("http://localhost:8080/transactiondetail/address",{
                params: {
                    address: this.address
                }
               }).then(res=>{
                  this.addressDTO=res.data;
                  this.total=res.data.transactionDTO.total;
                  this.pagesize = res.data.transactionDTO.pageSize;
                  this.page = res.data.transactionDTO.pageNum;
                  console.log(this.addressDTO);
                //   this.page = res.data.transactionDTOPageInfo.pageNum;
               })

         }

    },
    mounted(){
        var url=   new URL(location.href);
        this.address=  url.searchParams.get("address");
        this.getaddress(); 


    }
})