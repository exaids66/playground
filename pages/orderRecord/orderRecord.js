Page({

    /**
     * 页面的初始数据
     */
    data: {
        tstmsg:"NULL",
        msg:[{
            id:1,
            name:"杭州电子科技大学",
            state:"使用中",
            startTime:"2021.12.2 10:00",
            endTime:"2021.12.2 12:00",
            count:4,
            id:2,
            type:"篮球"
        },{
            id:2,
            name:"浙江理工大学",
            state:"已预约",
            startTime:"2021.12.2 10:00",
            endTime:"2021.12.2 12:00",
            count:4,
            id:2,
            type:"羽毛球"
        }]
        
    },


        order:function(){
            wx.navigateTo({
              url: '/pages/orderDetail/orderDetail',
            })
        },
      
})