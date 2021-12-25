// components/orderMasg/orderMasg.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        // name:{
        //     type:String,
        //     value:''
        // },
        // state:{
        //     type:String,
        //     value:''
        // },
        // courtId:{
        //     type:Number,
        //     value:0
        // },
        // courtType:{
        //     type:String,
        //     value:''
        // },
        // count:{
        //     type:Number,
        //     value:0
        // },
        // startTime:{
        //     type:String,
        //     value:''
        // },
        // endTime:{
        //     type:String,
        //     value:''
        // }
    },

    /**
     * 组件的初始数据
     */
    data: {
        tst :"111111111",
        msg:[{
            id:1,
            name:"杭州电子科技大学",
            state:"预约",
            startTime:"2021.12.2 10:00",
            endTime:"2021.12.2 12:00",
            count:4,
            type:"篮球"
        },{
            id:2,
            name:"浙江理工大学",
            state:"预约",
            startTime:"2021.12.2 10:00",
            endTime:"2021.12.2 12:00",
            count:2,
            type:"羽毛球"
        }]
    },

    /**
     * 组件的方法列表
     */
    methods: {
        change(event){
            
            wx.showToast({
                title: '用户名或密码错误！',
                icon:"none"
              });
              console.log(event.currentTarget.id);
            console.log(this.data.msg);
              this.setData({
                 'msg[0].state' : "已签到"
                // "msg["+ event.currentTarget.id + "].state" : "已签到"

                // [data.msg[event.currentTarget.id].state] : "已签到"
              })
            //   console.log(this.data.msg[event.currentTarget.id].state);

              console.log(  this.data.msg[event.currentTarget.id] );
        },
        cancel(){
            this.setData({
                tst:"abc"
            })
            console.log(tst);
        },
        Repair(){
            wx.navigateTo({
              url: '/pages/repair/repair'
              
            })
        },
        courtDetail(){
            wx.navigateTo({
              url: 'url',
            })
        }
    }
})
