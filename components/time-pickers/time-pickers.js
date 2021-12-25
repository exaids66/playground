// components/time-pickers/time-pickers.js

const date = new Date(); //获取系统日期
const years = []
const months = []
const days = []
const hours = []

const bigMonth = [1, 3, 5, 7, 8, 10, 12]

//将日期分开写入对应数组
var getYear = date.getFullYear()
var getMonth = date.getMonth()
var getDate = date.getDate()
var getHour = date.getHours()


//年
for (let i = getYear - 20; i <= getYear + 20; i++) {
  years.push(i);
}

//月
for (let i = 1; i <= 12; i++) {
  months.push(i);
}

//日
for (let i = 1; i <= 31; i++) {
  days.push(i);
}

//时
for (let i = 0; i <= 23; i++) {
  hours.push(i);
}




Component({

  properties: {

  },

  data: {
    years: years,
    months: months,
    days: days,
    hours: hours,
    value: [getYear - 2000, getMonth, getDate - 1, getHour],
    sValue: [getYear - 2000, getMonth, getDate - 1, getHour],
    eValue: [getYear - 2000, getMonth, getDate - 1, getHour + 1],
    sTime: getYear + "-" + (getMonth+1) + "-" + getDate + " " + getHour ,
    eTime: getYear + "-" + (getMonth+1) + "-" + getDate + " " + (getHour + 1),
    isDaytime: true,
    timeInput: '',
    propDate: false,
    isStart: true,
    animationData: {}, //内容动画
    animationMask: {}, //蒙板动画
  },

  ready() {
    this.animateTrans = wx.createAnimation({
      duration: 600,
      timingFunction: 'ease',
    })

    this.animateFade = wx.createAnimation({
      duration: 600,
      timingFunction: 'ease',
    })

  },

  methods: {

    getUnixTime(dateStr) {
      var newstr = dateStr.replace(/-/g, '/')
      var date = new Date(newstr)
      var time_str = date.getTime().toString()
      return time_str.substr(0, 10)
    },

    getString(value) {
      if (value > 9) {
        return "" + value;
      }
      return "0" + value;
    },

    //确定
    okBtnTime() {

      const smonth = this.getString(this.data.sValue[1] + 1)
      const sday = this.getString(this.data.sValue[2] + 1)
      const shour = this.getString(this.data.sValue[3])
      
      let sTime = (this.data.sValue[0] + 2000) + "-" + smonth + "-" + sday + " " + shour;
     
      //结束时间
      const emonth = this.getString(this.data.eValue[1] + 1)
      const eday = this.getString(this.data.eValue[2] + 1)
      const ehour = this.getString(this.data.eValue[3])

      let eTime = (this.data.eValue[0] + 2000) + "-" + emonth + "-" + eday + " " + ehour;

      const svalue = this.getUnixTime(sTime);
      const evalue = this.getUnixTime(eTime);

      if(svalue>evalue){
        wx.showToast({
          title: '结束时间必须大于开始时间',
          icon:"none"
        })
        return
      }

      this.triggerEvent('time', {
        sTime: sTime,
        eTime: eTime
      });
      this.setData({
        sTime: sTime,
        eTime: eTime
      })
      this.hideModal()
    },
    //取消
    noBtnTime() {
      this.setData({
        propDate: false
      })
    },
    //下一页
    onNext(e) {
      this.setData({
        isStart: false,
        hour: getHour + 1,
        value: this.data.eValue
      })
    },
    //上一页
    onPre(e) {
      this.setData({
        isStart: true,
        value: this.data.sValue
      })
    },
    //判断元素是否在一个数组
    contains: function (arr, obj) {
      var i = arr.length;
      while (i--) {
        if (arr[i] === obj) {
          return true;
        }
      }
      return false;
    },
    setDays: function (day) {
      const temp = [];
      for (let i = 1; i <= day; i++) {
        temp.push(i)
      }
      this.setData({
        days: temp,
      })
    },
    //选择滚动器改变触发事件
    bindChange: function (e) {
      const val = e.detail.value;
      //判断月的天数
      const setYear = this.data.years[val[0]];
      const setMonth = this.data.months[val[1]];
      const setDay = this.data.days[val[2]]
      const setHour = this.data.hours[val[3]]
   
      //闰年
      if (setMonth === 2) {
        if (setYear % 4 === 0 && setYear % 100 !== 0) {
          console.log('闰年')
          this.setDays(29);
        } else {
          console.log('非闰年')
          this.setDays(28);
        }
      } else {
        //大月
        if (this.contains(bigMonth, setMonth)) {
          this.setDays(31)
        } else {
          this.setDays(30)
        }
      }
      if (this.data.isStart) {
        this.setData({
          sValue: [setYear - 2000, setMonth - 1, setDay - 1, setHour]
        })
      } else {
        this.setData({
          eValue: [setYear - 2000, setMonth - 1, setDay - 1, setHour]
        })
      }
    },
    // 显示
    showModal: function (e) {
      this.setData({
        propDate: true
      })
      this.animateTrans.translateY(0).step()
      this.animateFade.opacity(1).step()
      this.setData({
        animationData: this.animateTrans.export(), //动画实例的export方法导出动画数据传递给组件的animation属性
        animationMask: this.animateFade.export()
      })
    },

    // 隐藏
    hideModal: function () {
      this.animateTrans.translateY(580).step()
      this.animateFade.opacity(0).step()
      this.setData({
        animationData: this.animateTrans.export(),
        animationMask: this.animateFade.export(),
      })
      setTimeout(() => {
        this.setData({
          propDate: false,
          isStart: true
        })
      }, 600)
    }

  }
})