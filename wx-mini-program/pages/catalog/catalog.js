var util = require('../../utils/util.js');
var api = require('../../config/api.js');

Page({
  data: {
    categoryList: [],
    goodsList: [],
    currentCategory: {},
    currentSubCategoryList: {},
    scrollLeft: 0,
    scrollTop: 0,
    goodsCount: 0,
    scrollHeight: 0
  },
  onLoad: function(options) {
    this.getCatalog();
  },
  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getCatalog();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },
  getCatalog: function() {
    //CatalogList
    let that = this;
    wx.showLoading({
      title: '加载中...',
    });
    util.request(api.CatalogList).then(function(res) {
      that.setData({
        categoryList: res.data.categoryList,
        currentCategory: res.data.currentCategory,
        currentSubCategoryList: res.data.currentSubCategory
      });
      wx.hideLoading();
    });
    util.request(api.GoodsCount).then(function(res) {
      that.setData({
        goodsCount: res.data.goodsCount
      });
    });

  },
  getCurrentCategory: function(id) {
    let that = this;
    util.request(api.CatalogCurrent, {
        id: id
      })
      .then(function(res) {
        that.setData({
          currentCategory: res.data.currentCategory,
          currentSubCategoryList: res.data.currentSubCategory
        });
      });
  },
  onReady: function() {
    // 页面渲染完成
  },
  onShow: function() {
    // 页面显示
  },
  onHide: function() {
    // 页面隐藏
  },
  onUnload: function() {
    // 页面关闭
  },
  getGoodsList: function(id) {
    var that = this;

    // 切换分类时清空商品列表
    that.setData({
        goodsList: [], // 清空旧数据
    });

    // 调用接口获取新分类商品列表
    util.request(api.GoodsList, {
        categoryId: id
    }).then(function(res) {
        that.setData({
            goodsList: res.data.goodsList, // 直接覆盖新数据
            totalPages: res.data.totalPages // 更新分页信息
        });
    }).catch(function(error) {
        console.error("Failed to load goods list:", error);
    });
},

  switchCate: function(event) {
    var that = this;
    var currentTarget = event.currentTarget;
    if (this.data.currentCategory.id == event.currentTarget.dataset.id) {
      return false;
    }
    this.getGoodsList(event.currentTarget.dataset.id);
    this.getCurrentCategory(event.currentTarget.dataset.id);
  }
})