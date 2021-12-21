// components/orderMasg/orderMasg.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {

    },

    /**
     * 组件的初始数据
     */
    data: {
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

    /**
     * 组件的方法列表
     */
    methods: {
        change:function(){
            console.log("aaa");
        }
    }
})
