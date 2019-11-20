var app = new Vue({
    el: '#app',
    data: {
        blocklist:[],
        pagesize:10,
        total:0,
        currentPage:1,

        
         
    },
    methods:{
       getblocklist(){
          axios.get("http://localhost:8080/blocks//getMoreblocks?page="+this.currentPage+"&pagesize="+this.pagesize).then(res=>{
              console.log(res);
              this.blocklist=res.data.list;
              this.total=res.data.total;
              this.pagesize=res.data.pageSize;
          })

       },
       handleSizeChange(val){
          this.pagesize=val;
          this.getblocklist();

       },
       handleCurrentChange(val){
         this.currentPage=val;
         this.getblocklist();

       }
    },
    mounted(){
       this.getblocklist();
    }
})