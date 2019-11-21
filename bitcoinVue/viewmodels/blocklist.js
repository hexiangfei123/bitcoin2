var app = new Vue({
    el: '#app',
    data: {
        blocklist:[],
        unconfirmedTransactions:[],
        input:"",
        activeName:"aaa",
        
            tabPosition: 'left'
         
    },
    computed:{
      newBlocks(){
          return this.blocklist.map(block=>{
            var newBlock = block;
            newBlock.fornow = moment.unix(block.time).fromNow();
            return newBlock;
          });
      }
    },
    methods:{
        handleClick(tab) {
        

           let queryType;

           if(tab.name == 'aaa') {
               queryType = 1;
           }else if(tab.name == 'bbb') {
               queryType = 2;
           }else if(tab.name == 'ccc') {
               queryType = 3;
           }
           console.log("/////");
           console.log(queryType);
           sessionStorage.setItem("type", queryType)
           

          // 将新的值和url放在一起拼成一个完整的路径
        //    this.$router.push({
        //        path: '/http://localhost:5000/blocklist',
        //        query: {
        //            type: queryType || 1
        //        }
        //    });


        },
        updateType() {
            let type =  sessionStorage.getItem("type");
            console.log("ssssss");
            console.log(type);

            

			//通过拿到的值不同，更改activeName的值
            if(type == 1) {
                this.activeName = 'aaa';
            }else if(type == 2) {
                this.activeName = 'bbb';
            }else if(type == 3) {
                this.activeName = 'ccc';
            }else{
                this.activeName = 'aaa';
            }
            console.log(this.activeName);
        },

       getblocklist(){
          axios.get("http://localhost:8080/blocks/getnewblocks").then(res=>{
              console.log(res);
              this.blocklist=res.data;
          })

       },
       getunconfirmedTransactions(){
        axios.get("http://localhost:8080/transaction/getRecentUnconfirmed").then(res=>{
            console.log(res);
            this.unconfirmedTransactions=res.data;
        })
       },
       bitcoinPushConnect() {
        console.log('bitcoin push connecting');

        this.socket = new SockJS('http://localhost:8080/bitcoin');
        this.stompclient = Stomp.over(this.socket);
        this.stompclient.connect({}, frame => {
            app.unconfirmedTransactions=frame;
            console.log(frame);
            this.stompclient.subscribe('/bitcoin/deltaTx', function (data) {
                console.log("*********");
                console.log(data);
               
                console.log("*********");

            });
        });

    },
    handleConnect() {
        console.log('connect click');
        this.bitcoinPushConnect();
    }
    },
    mounted(){
        this.updateType();
       this.getblocklist();
      // this.getunconfirmedTransactions();



    }
})