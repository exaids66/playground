// components/inputOrderMsg/inputOrderMsg.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        question:{
            type:String,
            value:"我是默认值"
        },
        answer:{
            optionalTypes:[String,Number],
            value:"我是answer默认值"
        },
        tab:{
            type:String,
            value:"<text>ehhe</text>"
        }
    },

    /**
     * 组件的初始数据
     */
    data: {
        msg:[{
            title:"预约场地",
            slt:"场地"         
        },{
            title:"预约时间",
            slt:"时间"
        },{
            title:"联系电话",
            slt:"电话"
        },{
            title:"使用人数",
            slt:"电话"
        }]
    },

    /**
     * 组件的方法列表
     */
    methods: {

    }
})
