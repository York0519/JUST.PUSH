/*! jQuery UI - v1.11.4 - 2016-04-14
* http://jqueryui.com
* Includes: core.js, widget.js, position.js, autocomplete.js, menu.js
* Copyright jQuery Foundation and other contributors; Licensed MIT */

(function (t) {
  "function" == typeof define && define.amd ? define(["jquery"], t) : t(jQuery)
})(function (t) {
  function e(e, s) {
    var n, a, o, r = e.nodeName.toLowerCase();
    return "area" === r ? (n = e.parentNode, a = n.name, e.href && a && "map"
    === n.nodeName.toLowerCase() ? (o = t("img[usemap='#" + a + "']")[0], !!o
    && i(o)) : !1) : (/^(input|select|textarea|button|object)$/.test(r)
        ? !e.disabled : "a" === r ? e.href || s : s) && i(e)
  }

  function i(e) {
    return t.expr.filters.visible(e) && !t(e).parents().addBack().filter(
        function () {
          return "hidden" === t.css(this, "visibility")
        }).length
  }

  t.ui = t.ui || {}, t.extend(t.ui, {
    version: "1.11.4",
    keyCode: {
      BACKSPACE: 8,
      COMMA: 188,
      DELETE: 46,
      DOWN: 40,
      END: 35,
      ENTER: 13,
      ESCAPE: 27,
      HOME: 36,
      LEFT: 37,
      PAGE_DOWN: 34,
      PAGE_UP: 33,
      PERIOD: 190,
      RIGHT: 39,
      SPACE: 32,
      TAB: 9,
      UP: 38
    }
  }), t.fn.extend({
    scrollParent: function (e) {
      var i = this.css("position"), s = "absolute" === i,
          n = e ? /(auto|scroll|hidden)/ : /(auto|scroll)/,
          a = this.parents().filter(function () {
            var e = t(this);
            return s && "static" === e.css("position") ? !1 : n.test(
                e.css("overflow") + e.css("overflow-y") + e.css("overflow-x"))
          }).eq(0);
      return "fixed" !== i && a.length ? a : t(
          this[0].ownerDocument || document)
    }, uniqueId: function () {
      var t = 0;
      return function () {
        return this.each(function () {
          this.id || (this.id = "ui-id-" + ++t)
        })
      }
    }(), removeUniqueId: function () {
      return this.each(function () {
        /^ui-id-\d+$/.test(this.id) && t(this).removeAttr("id")
      })
    }
  }), t.extend(t.expr[":"], {
    data: t.expr.createPseudo ? t.expr.createPseudo(function (e) {
      return function (i) {
        return !!t.data(i, e)
      }
    }) : function (e, i, s) {
      return !!t.data(e, s[3])
    }, focusable: function (i) {
      return e(i, !isNaN(t.attr(i, "tabindex")))
    }, tabbable: function (i) {
      var s = t.attr(i, "tabindex"), n = isNaN(s);
      return (n || s >= 0) && e(i, !n)
    }
  }), t("<a>").outerWidth(1).jquery || t.each(["Width", "Height"],
      function (e, i) {
        function s(e, i, s, a) {
          return t.each(n, function () {
            i -= parseFloat(t.css(e, "padding" + this)) || 0, s
            && (i -= parseFloat(t.css(e, "border" + this + "Width")) || 0), a
            && (i -= parseFloat(t.css(e, "margin" + this)) || 0)
          }), i
        }

        var n = "Width" === i ? ["Left", "Right"] : ["Top", "Bottom"],
            a = i.toLowerCase(), o = {
              innerWidth: t.fn.innerWidth,
              innerHeight: t.fn.innerHeight,
              outerWidth: t.fn.outerWidth,
              outerHeight: t.fn.outerHeight
            };
        t.fn["inner" + i] = function (e) {
          return void 0 === e ? o["inner" + i].call(this) : this.each(
              function () {
                t(this).css(a, s(this, e) + "px")
              })
        }, t.fn["outer" + i] = function (e, n) {
          return "number" != typeof e ? o["outer" + i].call(this, e)
              : this.each(function () {
                t(this).css(a, s(this, e, !0, n) + "px")
              })
        }
      }), t.fn.addBack || (t.fn.addBack = function (t) {
    return this.add(null == t ? this.prevObject : this.prevObject.filter(t))
  }), t("<a>").data("a-b", "a").removeData("a-b").data("a-b")
  && (t.fn.removeData = function (e) {
    return function (i) {
      return arguments.length ? e.call(this, t.camelCase(i)) : e.call(this)
    }
  }(t.fn.removeData)), t.ui.ie = !!/msie [\w.]+/.exec(
      navigator.userAgent.toLowerCase()), t.fn.extend({
    focus: function (e) {
      return function (i, s) {
        return "number" == typeof i ? this.each(function () {
          var e = this;
          setTimeout(function () {
            t(e).focus(), s && s.call(e)
          }, i)
        }) : e.apply(this, arguments)
      }
    }(t.fn.focus), disableSelection: function () {
      var t = "onselectstart" in document.createElement("div") ? "selectstart"
          : "mousedown";
      return function () {
        return this.bind(t + ".ui-disableSelection", function (t) {
          t.preventDefault()
        })
      }
    }(), enableSelection: function () {
      return this.unbind(".ui-disableSelection")
    }, zIndex: function (e) {
      if (void 0 !== e) {
        return this.css("zIndex", e);
      }
      if (this.length) {
        for (var i, s, n = t(this[0]);
            n.length && n[0] !== document;) {
          if (i = n.css("position"), ("absolute" === i || "relative" === i
              || "fixed" === i) && (s = parseInt(n.css("zIndex"), 10), !isNaN(s)
          && 0 !== s)) {
            return s;
          }
          n = n.parent()
        }
      }
      return 0
    }
  }), t.ui.plugin = {
    add: function (e, i, s) {
      var n, a = t.ui[e].prototype;
      for (n in s) {
        a.plugins[n] = a.plugins[n] || [], a.plugins[n].push(
            [i, s[n]])
      }
    }, call: function (t, e, i, s) {
      var n, a = t.plugins[e];
      if (a && (s || t.element[0].parentNode && 11
          !== t.element[0].parentNode.nodeType)) {
        for (n = 0; a.length > n;
            n++) {
          t.options[a[n][0]] && a[n][1].apply(t.element, i)
        }
      }
    }
  };
  var s = 0, n = Array.prototype.slice;
  t.cleanData = function (e) {
    return function (i) {
      var s, n, a;
      for (a = 0; null != (n = i[a]); a++) {
        try {
          s = t._data(n, "events"), s && s.remove && t(n).triggerHandler(
              "remove")
        } catch (o) {
        }
      }
      e(i)
    }
  }(t.cleanData), t.widget = function (e, i, s) {
    var n, a, o, r, h = {}, l = e.split(".")[0];
    return e = e.split(".")[1], n = l + "-" + e, s
    || (s = i, i = t.Widget), t.expr[":"][n.toLowerCase()] = function (e) {
      return !!t.data(e, n)
    }, t[l] = t[l] || {}, a = t[l][e], o = t[l][e] = function (t, e) {
      return this._createWidget ? (arguments.length && this._createWidget(t,
          e), void 0) : new o(t, e)
    }, t.extend(o, a, {
      version: s.version,
      _proto: t.extend({}, s),
      _childConstructors: []
    }), r = new i, r.options = t.widget.extend({}, r.options), t.each(s,
        function (e, s) {
          return t.isFunction(s) ? (h[e] = function () {
            var t = function () {
              return i.prototype[e].apply(this, arguments)
            }, n = function (t) {
              return i.prototype[e].apply(this, t)
            };
            return function () {
              var e, i = this._super, a = this._superApply;
              return this._super = t, this._superApply = n, e = s.apply(this,
                  arguments), this._super = i, this._superApply = a, e
            }
          }(), void 0) : (h[e] = s, void 0)
        }), o.prototype = t.widget.extend(r,
        {widgetEventPrefix: a ? r.widgetEventPrefix || e : e}, h,
        {constructor: o, namespace: l, widgetName: e, widgetFullName: n}), a
        ? (t.each(a._childConstructors, function (e, i) {
          var s = i.prototype;
          t.widget(s.namespace + "." + s.widgetName, o, i._proto)
        }), delete a._childConstructors) : i._childConstructors.push(
            o), t.widget.bridge(e, o), o
  }, t.widget.extend = function (e) {
    for (var i, s, a = n.call(arguments, 1), o = 0, r = a.length; r > o;
        o++) {
      for (i in a[o]) {
        s = a[o][i], a[o].hasOwnProperty(i) && void 0 !== s
        && (e[i] = t.isPlainObject(s) ? t.isPlainObject(e[i]) ? t.widget.extend(
            {},
            e[i], s) : t.widget.extend({}, s) : s);
      }
    }
    return e
  }, t.widget.bridge = function (e, i) {
    var s = i.prototype.widgetFullName || e;
    t.fn[e] = function (a) {
      var o = "string" == typeof a, r = n.call(arguments, 1), h = this;
      return o ? this.each(function () {
        var i, n = t.data(this, s);
        return "instance" === a ? (h = n, !1) : n ? t.isFunction(n[a]) && "_"
            !== a.charAt(0) ? (i = n[a].apply(n, r), i !== n && void 0 !== i
            ? (h = i && i.jquery ? h.pushStack(i.get()) : i, !1) : void 0)
            : t.error(
                "no such method '" + a + "' for " + e + " widget instance")
            : t.error(
                "cannot call methods on " + e + " prior to initialization; "
                + "attempted to call method '" + a + "'")
      }) : (r.length && (a = t.widget.extend.apply(null,
          [a].concat(r))), this.each(function () {
        var e = t.data(this, s);
        e ? (e.option(a || {}), e._init && e._init()) : t.data(this, s,
            new i(a, this))
      })), h
    }
  }, t.Widget = function () {
  }, t.Widget._childConstructors = [], t.Widget.prototype = {
    widgetName: "widget",
    widgetEventPrefix: "",
    defaultElement: "<div>",
    options: {disabled: !1, create: null},
    _createWidget: function (e, i) {
      i = t(i || this.defaultElement || this)[0], this.element = t(
          i), this.uuid = s++, this.eventNamespace = "." + this.widgetName
          + this.uuid, this.bindings = t(), this.hoverable = t(), this.focusable = t(), i
      !== this && (t.data(i, this.widgetFullName, this), this._on(!0,
          this.element, {
            remove: function (t) {
              t.target === i && this.destroy()
            }
          }), this.document = t(
          i.style ? i.ownerDocument : i.document || i), this.window = t(
          this.document[0].defaultView
          || this.document[0].parentWindow)), this.options = t.widget.extend({},
          this.options, this._getCreateOptions(),
          e), this._create(), this._trigger("create", null,
          this._getCreateEventData()), this._init()
    },
    _getCreateOptions: t.noop,
    _getCreateEventData: t.noop,
    _create: t.noop,
    _init: t.noop,
    destroy: function () {
      this._destroy(), this.element.unbind(this.eventNamespace).removeData(
          this.widgetFullName).removeData(
          t.camelCase(this.widgetFullName)), this.widget().unbind(
          this.eventNamespace).removeAttr("aria-disabled").removeClass(
          this.widgetFullName + "-disabled "
          + "ui-state-disabled"), this.bindings.unbind(
          this.eventNamespace), this.hoverable.removeClass(
          "ui-state-hover"), this.focusable.removeClass("ui-state-focus")
    },
    _destroy: t.noop,
    widget: function () {
      return this.element
    },
    option: function (e, i) {
      var s, n, a, o = e;
      if (0 === arguments.length) {
        return t.widget.extend({}, this.options);
      }
      if ("string" == typeof e) {
        if (o = {}, s = e.split(
            "."), e = s.shift(), s.length) {
          for (n = o[e] = t.widget.extend({}, this.options[e]), a = 0;
              s.length - 1 > a; a++) {
            n[s[a]] = n[s[a]] || {}, n = n[s[a]];
          }
          if (e = s.pop(), 1 === arguments.length) {
            return void 0 === n[e] ? null
                : n[e];
          }
          n[e] = i
        } else {
          if (1 === arguments.length) {
            return void 0 === this.options[e] ? null
                : this.options[e];
          }
          o[e] = i
        }
      }
      return this._setOptions(o), this
    },
    _setOptions: function (t) {
      var e;
      for (e in t) {
        this._setOption(e, t[e]);
      }
      return this
    },
    _setOption: function (t, e) {
      return this.options[t] = e, "disabled" === t
      && (this.widget().toggleClass(this.widgetFullName + "-disabled", !!e), e
      && (this.hoverable.removeClass(
          "ui-state-hover"), this.focusable.removeClass(
          "ui-state-focus"))), this
    },
    enable: function () {
      return this._setOptions({disabled: !1})
    },
    disable: function () {
      return this._setOptions({disabled: !0})
    },
    _on: function (e, i, s) {
      var n, a = this;
      "boolean" != typeof e && (s = i, i = e, e = !1), s ? (i = n = t(
          i), this.bindings = this.bindings.add(i))
          : (s = i, i = this.element, n = this.widget()), t.each(s,
          function (s, o) {
            function r() {
              return e || a.options.disabled !== !0 && !t(this).hasClass(
                  "ui-state-disabled") ? ("string" == typeof o ? a[o]
                  : o).apply(a, arguments) : void 0
            }

            "string" != typeof o && (r.guid = o.guid = o.guid || r.guid
                || t.guid++);
            var h = s.match(/^([\w:-]*)\s*(.*)$/), l = h[1] + a.eventNamespace,
                u = h[2];
            u ? n.delegate(u, l, r) : i.bind(l, r)
          })
    },
    _off: function (e, i) {
      i = (i || "").split(" ").join(this.eventNamespace + " ")
          + this.eventNamespace, e.unbind(i).undelegate(i), this.bindings = t(
          this.bindings.not(e).get()), this.focusable = t(
          this.focusable.not(e).get()), this.hoverable = t(
          this.hoverable.not(e).get())
    },
    _delay: function (t, e) {
      function i() {
        return ("string" == typeof t ? s[t] : t).apply(s, arguments)
      }

      var s = this;
      return setTimeout(i, e || 0)
    },
    _hoverable: function (e) {
      this.hoverable = this.hoverable.add(e), this._on(e, {
        mouseenter: function (e) {
          t(e.currentTarget).addClass("ui-state-hover")
        }, mouseleave: function (e) {
          t(e.currentTarget).removeClass("ui-state-hover")
        }
      })
    },
    _focusable: function (e) {
      this.focusable = this.focusable.add(e), this._on(e, {
        focusin: function (e) {
          t(e.currentTarget).addClass("ui-state-focus")
        }, focusout: function (e) {
          t(e.currentTarget).removeClass("ui-state-focus")
        }
      })
    },
    _trigger: function (e, i, s) {
      var n, a, o = this.options[e];
      if (s = s || {}, i = t.Event(i), i.type = (e === this.widgetEventPrefix
          ? e : this.widgetEventPrefix
          + e).toLowerCase(), i.target = this.element[0], a = i.originalEvent) {
        for (n in
            a) {
          n in i || (i[n] = a[n]);
        }
      }
      return this.element.trigger(i, s), !(t.isFunction(o) && o.apply(
          this.element[0], [i].concat(s)) === !1 || i.isDefaultPrevented())
    }
  }, t.each({show: "fadeIn", hide: "fadeOut"}, function (e, i) {
    t.Widget.prototype["_" + e] = function (s, n, a) {
      "string" == typeof n && (n = {effect: n});
      var o, r = n ? n === !0 || "number" == typeof n ? i : n.effect || i : e;
      n = n || {}, "number" == typeof n
      && (n = {duration: n}), o = !t.isEmptyObject(n), n.complete = a, n.delay
      && s.delay(n.delay), o && t.effects && t.effects.effect[r] ? s[e](n) : r
      !== e && s[r] ? s[r](n.duration, n.easing, a) : s.queue(function (i) {
        t(this)[e](), a && a.call(s[0]), i()
      })
    }
  }), t.widget, function () {
    function e(t, e, i) {
      return [parseFloat(t[0]) * (p.test(t[0]) ? e / 100 : 1),
        parseFloat(t[1]) * (p.test(t[1]) ? i / 100 : 1)]
    }

    function i(e, i) {
      return parseInt(t.css(e, i), 10) || 0
    }

    function s(e) {
      var i = e[0];
      return 9 === i.nodeType ? {
        width: e.width(),
        height: e.height(),
        offset: {top: 0, left: 0}
      } : t.isWindow(i) ? {
        width: e.width(),
        height: e.height(),
        offset: {top: e.scrollTop(), left: e.scrollLeft()}
      } : i.preventDefault ? {
        width: 0,
        height: 0,
        offset: {top: i.pageY, left: i.pageX}
      } : {width: e.outerWidth(), height: e.outerHeight(), offset: e.offset()}
    }

    t.ui = t.ui || {};
    var n, a, o = Math.max, r = Math.abs, h = Math.round,
        l = /left|center|right/, u = /top|center|bottom/,
        c = /[\+\-]\d+(\.[\d]+)?%?/, d = /^\w+/, p = /%$/, f = t.fn.position;
    t.position = {
      scrollbarWidth: function () {
        if (void 0 !== n) {
          return n;
        }
        var e, i, s = t(
            "<div style='display:block;position:absolute;width:50px;height:50px;overflow:hidden;'><div style='height:100px;width:auto;'></div></div>"),
            a = s.children()[0];
        return t("body").append(s), e = a.offsetWidth, s.css("overflow",
            "scroll"), i = a.offsetWidth, e === i
        && (i = s[0].clientWidth), s.remove(), n = e - i
      }, getScrollInfo: function (e) {
        var i = e.isWindow || e.isDocument ? "" : e.element.css("overflow-x"),
            s = e.isWindow || e.isDocument ? "" : e.element.css("overflow-y"),
            n = "scroll" === i || "auto" === i && e.width
                < e.element[0].scrollWidth,
            a = "scroll" === s || "auto" === s && e.height
                < e.element[0].scrollHeight;
        return {
          width: a ? t.position.scrollbarWidth() : 0,
          height: n ? t.position.scrollbarWidth() : 0
        }
      }, getWithinInfo: function (e) {
        var i = t(e || window), s = t.isWindow(i[0]),
            n = !!i[0] && 9 === i[0].nodeType;
        return {
          element: i,
          isWindow: s,
          isDocument: n,
          offset: i.offset() || {left: 0, top: 0},
          scrollLeft: i.scrollLeft(),
          scrollTop: i.scrollTop(),
          width: s || n ? i.width() : i.outerWidth(),
          height: s || n ? i.height() : i.outerHeight()
        }
      }
    }, t.fn.position = function (n) {
      if (!n || !n.of) {
        return f.apply(this, arguments);
      }
      n = t.extend({}, n);
      var p, m, g, v, _, b, y = t(n.of), x = t.position.getWithinInfo(n.within),
          w = t.position.getScrollInfo(x),
          k = (n.collision || "flip").split(" "), D = {};
      return b = s(y), y[0].preventDefault
      && (n.at = "left top"), m = b.width, g = b.height, v = b.offset, _ = t.extend(
          {}, v), t.each(["my", "at"], function () {
        var t, e, i = (n[this] || "").split(" ");
        1 === i.length && (i = l.test(i[0]) ? i.concat(["center"]) : u.test(
            i[0]) ? ["center"].concat(i) : ["center", "center"]), i[0] = l.test(
            i[0]) ? i[0] : "center", i[1] = u.test(i[1]) ? i[1]
            : "center", t = c.exec(i[0]), e = c.exec(i[1]), D[this] = [t ? t[0]
            : 0, e ? e[0] : 0], n[this] = [d.exec(i[0])[0], d.exec(i[1])[0]]
      }), 1 === k.length && (k[1] = k[0]), "right" === n.at[0] ? _.left += m
          : "center" === n.at[0] && (_.left += m / 2), "bottom" === n.at[1]
          ? _.top += g : "center" === n.at[1] && (_.top += g / 2), p = e(D.at,
          m, g), _.left += p[0], _.top += p[1], this.each(function () {
        var s, l, u = t(this), c = u.outerWidth(), d = u.outerHeight(),
            f = i(this, "marginLeft"), b = i(this, "marginTop"),
            T = c + f + i(this, "marginRight") + w.width,
            S = d + b + i(this, "marginBottom") + w.height, M = t.extend({}, _),
            C = e(D.my, u.outerWidth(), u.outerHeight());
        "right" === n.my[0] ? M.left -= c : "center" === n.my[0] && (M.left -= c
            / 2), "bottom" === n.my[1] ? M.top -= d : "center" === n.my[1]
            && (M.top -= d / 2), M.left += C[0], M.top += C[1], a
        || (M.left = h(M.left), M.top = h(M.top)), s = {
          marginLeft: f,
          marginTop: b
        }, t.each(["left", "top"], function (e, i) {
          t.ui.position[k[e]] && t.ui.position[k[e]][i](M, {
            targetWidth: m,
            targetHeight: g,
            elemWidth: c,
            elemHeight: d,
            collisionPosition: s,
            collisionWidth: T,
            collisionHeight: S,
            offset: [p[0] + C[0], p[1] + C[1]],
            my: n.my,
            at: n.at,
            within: x,
            elem: u
          })
        }), n.using && (l = function (t) {
          var e = v.left - M.left, i = e + m - c, s = v.top - M.top,
              a = s + g - d, h = {
                target: {
                  element: y,
                  left: v.left,
                  top: v.top,
                  width: m,
                  height: g
                },
                element: {
                  element: u,
                  left: M.left,
                  top: M.top,
                  width: c,
                  height: d
                },
                horizontal: 0 > i ? "left" : e > 0 ? "right" : "center",
                vertical: 0 > a ? "top" : s > 0 ? "bottom" : "middle"
              };
          c > m && m > r(e + i) && (h.horizontal = "center"), d > g && g > r(
              s + a) && (h.vertical = "middle"), h.important = o(r(e), r(i))
          > o(r(s), r(a)) ? "horizontal" : "vertical", n.using.call(this, t, h)
        }), u.offset(t.extend(M, {using: l}))
      })
    }, t.ui.position = {
      fit: {
        left: function (t, e) {
          var i, s = e.within, n = s.isWindow ? s.scrollLeft : s.offset.left,
              a = s.width, r = t.left - e.collisionPosition.marginLeft,
              h = n - r, l = r + e.collisionWidth - a - n;
          e.collisionWidth > a ? h > 0 && 0 >= l ? (i = t.left + h
              + e.collisionWidth - a - n, t.left += h - i) : t.left = l > 0 && 0
          >= h ? n : h > l ? n + a - e.collisionWidth : n : h > 0 ? t.left += h
              : l > 0 ? t.left -= l : t.left = o(t.left - r, t.left)
        }, top: function (t, e) {
          var i, s = e.within, n = s.isWindow ? s.scrollTop : s.offset.top,
              a = e.within.height, r = t.top - e.collisionPosition.marginTop,
              h = n - r, l = r + e.collisionHeight - a - n;
          e.collisionHeight > a ? h > 0 && 0 >= l ? (i = t.top + h
              + e.collisionHeight - a - n, t.top += h - i) : t.top = l > 0 && 0
          >= h ? n : h > l ? n + a - e.collisionHeight : n : h > 0 ? t.top += h
              : l > 0 ? t.top -= l : t.top = o(t.top - r, t.top)
        }
      }, flip: {
        left: function (t, e) {
          var i, s, n = e.within, a = n.offset.left + n.scrollLeft, o = n.width,
              h = n.isWindow ? n.scrollLeft : n.offset.left,
              l = t.left - e.collisionPosition.marginLeft, u = l - h,
              c = l + e.collisionWidth - o - h,
              d = "left" === e.my[0] ? -e.elemWidth : "right" === e.my[0]
                  ? e.elemWidth : 0,
              p = "left" === e.at[0] ? e.targetWidth : "right" === e.at[0]
                  ? -e.targetWidth : 0, f = -2 * e.offset[0];
          0 > u ? (i = t.left + d + p + f + e.collisionWidth - o - a, (0 > i
              || r(u) > i) && (t.left += d + p + f)) : c > 0 && (s = t.left
              - e.collisionPosition.marginLeft + d + p + f - h, (s > 0 || c > r(
              s)) && (t.left += d + p + f))
        }, top: function (t, e) {
          var i, s, n = e.within, a = n.offset.top + n.scrollTop, o = n.height,
              h = n.isWindow ? n.scrollTop : n.offset.top,
              l = t.top - e.collisionPosition.marginTop, u = l - h,
              c = l + e.collisionHeight - o - h, d = "top" === e.my[1],
              p = d ? -e.elemHeight : "bottom" === e.my[1] ? e.elemHeight : 0,
              f = "top" === e.at[1] ? e.targetHeight : "bottom" === e.at[1]
                  ? -e.targetHeight : 0, m = -2 * e.offset[1];
          0 > u ? (s = t.top + p + f + m + e.collisionHeight - o - a, (0 > s
              || r(u) > s) && (t.top += p + f + m)) : c > 0 && (i = t.top
              - e.collisionPosition.marginTop + p + f + m - h, (i > 0 || c > r(
              i)) && (t.top += p + f + m))
        }
      }, flipfit: {
        left: function () {
          t.ui.position.flip.left.apply(this,
              arguments), t.ui.position.fit.left.apply(this, arguments)
        }, top: function () {
          t.ui.position.flip.top.apply(this,
              arguments), t.ui.position.fit.top.apply(this, arguments)
        }
      }
    }, function () {
      var e, i, s, n, o, r = document.getElementsByTagName("body")[0],
          h = document.createElement("div");
      e = document.createElement(r ? "div" : "body"), s = {
        visibility: "hidden",
        width: 0,
        height: 0,
        border: 0,
        margin: 0,
        background: "none"
      }, r && t.extend(s,
          {position: "absolute", left: "-1000px", top: "-1000px"});
      for (o in s) {
        e.style[o] = s[o];
      }
      e.appendChild(h), i = r || document.documentElement, i.insertBefore(e,
          i.firstChild), h.style.cssText = "position: absolute; left: 10.7432222px;", n = t(
          h).offset().left, a = n > 10 && 11
          > n, e.innerHTML = "", i.removeChild(e)
    }()
  }(), t.ui.position, t.widget("ui.menu", {
    version: "1.11.4",
    defaultElement: "<ul>",
    delay: 300,
    options: {
      icons: {submenu: "ui-icon-carat-1-e"},
      items: "> *",
      menus: "ul",
      position: {my: "left-1 top", at: "right top"},
      role: "menu",
      blur: null,
      focus: null,
      select: null
    },
    _create: function () {
      this.activeMenu = this.element, this.mouseHandled = !1, this.element.uniqueId().addClass(
          "ui-menu ui-widget ui-widget-content").toggleClass("ui-menu-icons",
          !!this.element.find(".ui-icon").length).attr(
          {role: this.options.role, tabIndex: 0}), this.options.disabled
      && this.element.addClass("ui-state-disabled").attr("aria-disabled",
          "true"), this._on({
        "mousedown .ui-menu-item": function (t) {
          t.preventDefault()
        },
        "click .ui-menu-item": function (e) {
          var i = t(e.target);
          !this.mouseHandled && i.not(".ui-state-disabled").length
          && (this.select(e), e.isPropagationStopped()
          || (this.mouseHandled = !0), i.has(".ui-menu").length ? this.expand(e)
              : !this.element.is(":focus") && t(
              this.document[0].activeElement).closest(".ui-menu").length
              && (this.element.trigger("focus", [!0]), this.active && 1
              === this.active.parents(".ui-menu").length && clearTimeout(
                  this.timer)))
        },
        "mouseenter .ui-menu-item": function (e) {
          if (!this.previousFilter) {
            var i = t(e.currentTarget);
            i.siblings(".ui-state-active").removeClass(
                "ui-state-active"), this.focus(e, i)
          }
        },
        mouseleave: "collapseAll",
        "mouseleave .ui-menu": "collapseAll",
        focus: function (t, e) {
          var i = this.active || this.element.find(this.options.items).eq(0);
          e || this.focus(t, i)
        },
        blur: function (e) {
          this._delay(function () {
            t.contains(this.element[0], this.document[0].activeElement)
            || this.collapseAll(e)
          })
        },
        keydown: "_keydown"
      }), this.refresh(), this._on(this.document, {
        click: function (t) {
          this._closeOnDocumentClick(t) && this.collapseAll(
              t), this.mouseHandled = !1
        }
      })
    },
    _destroy: function () {
      this.element.removeAttr("aria-activedescendant").find(
          ".ui-menu").addBack().removeClass(
          "ui-menu ui-widget ui-widget-content ui-menu-icons ui-front").removeAttr(
          "role").removeAttr("tabIndex").removeAttr(
          "aria-labelledby").removeAttr("aria-expanded").removeAttr(
          "aria-hidden").removeAttr(
          "aria-disabled").removeUniqueId().show(), this.element.find(
          ".ui-menu-item").removeClass("ui-menu-item").removeAttr(
          "role").removeAttr("aria-disabled").removeUniqueId().removeClass(
          "ui-state-hover").removeAttr("tabIndex").removeAttr(
          "role").removeAttr("aria-haspopup").children().each(function () {
        var e = t(this);
        e.data("ui-menu-submenu-carat") && e.remove()
      }), this.element.find(".ui-menu-divider").removeClass(
          "ui-menu-divider ui-widget-content")
    },
    _keydown: function (e) {
      var i, s, n, a, o = !0;
      switch (e.keyCode) {
        case t.ui.keyCode.PAGE_UP:
          this.previousPage(e);
          break;
        case t.ui.keyCode.PAGE_DOWN:
          this.nextPage(e);
          break;
        case t.ui.keyCode.HOME:
          this._move("first", "first", e);
          break;
        case t.ui.keyCode.END:
          this._move("last", "last", e);
          break;
        case t.ui.keyCode.UP:
          this.previous(e);
          break;
        case t.ui.keyCode.DOWN:
          this.next(e);
          break;
        case t.ui.keyCode.LEFT:
          this.collapse(e);
          break;
        case t.ui.keyCode.RIGHT:
          this.active && !this.active.is(".ui-state-disabled") && this.expand(
              e);
          break;
        case t.ui.keyCode.ENTER:
        case t.ui.keyCode.SPACE:
          this._activate(e);
          break;
        case t.ui.keyCode.ESCAPE:
          this.collapse(e);
          break;
        default:
          o = !1, s = this.previousFilter || "", n = String.fromCharCode(
              e.keyCode), a = !1, clearTimeout(this.filterTimer), n === s
              ? a = !0 : n = s + n, i = this._filterMenuItems(n), i = a && -1
          !== i.index(this.active.next()) ? this.active.nextAll(".ui-menu-item")
              : i, i.length || (n = String.fromCharCode(
              e.keyCode), i = this._filterMenuItems(n)), i.length ? (this.focus(
              e, i), this.previousFilter = n, this.filterTimer = this._delay(
              function () {
                delete this.previousFilter
              }, 1e3)) : delete this.previousFilter
      }
      o && e.preventDefault()
    },
    _activate: function (t) {
      this.active.is(".ui-state-disabled") || (this.active.is(
          "[aria-haspopup='true']") ? this.expand(t) : this.select(t))
    },
    refresh: function () {
      var e, i, s = this, n = this.options.icons.submenu,
          a = this.element.find(this.options.menus);
      this.element.toggleClass("ui-menu-icons",
          !!this.element.find(".ui-icon").length), a.filter(
          ":not(.ui-menu)").addClass(
          "ui-menu ui-widget ui-widget-content ui-front").hide().attr({
        role: this.options.role,
        "aria-hidden": "true",
        "aria-expanded": "false"
      }).each(function () {
        var e = t(this), i = e.parent(),
            s = t("<span>").addClass("ui-menu-icon ui-icon " + n).data(
                "ui-menu-submenu-carat", !0);
        i.attr("aria-haspopup", "true").prepend(s), e.attr("aria-labelledby",
            i.attr("id"))
      }), e = a.add(this.element), i = e.find(this.options.items), i.not(
          ".ui-menu-item").each(function () {
        var e = t(this);
        s._isDivider(e) && e.addClass("ui-widget-content ui-menu-divider")
      }), i.not(".ui-menu-item, .ui-menu-divider").addClass(
          "ui-menu-item").uniqueId().attr(
          {tabIndex: -1, role: this._itemRole()}), i.filter(
          ".ui-state-disabled").attr("aria-disabled", "true"), this.active
      && !t.contains(this.element[0], this.active[0]) && this.blur()
    },
    _itemRole: function () {
      return {menu: "menuitem", listbox: "option"}[this.options.role]
    },
    _setOption: function (t, e) {
      "icons" === t && this.element.find(".ui-menu-icon").removeClass(
          this.options.icons.submenu).addClass(e.submenu), "disabled" === t
      && this.element.toggleClass("ui-state-disabled", !!e).attr(
          "aria-disabled", e), this._super(t, e)
    },
    focus: function (t, e) {
      var i, s;
      this.blur(t, t && "focus" === t.type), this._scrollIntoView(
          e), this.active = e.first(), s = this.active.addClass(
          "ui-state-focus").removeClass("ui-state-active"), this.options.role
      && this.element.attr("aria-activedescendant",
          s.attr("id")), this.active.parent().closest(".ui-menu-item").addClass(
          "ui-state-active"), t && "keydown" === t.type ? this._close()
          : this.timer = this._delay(function () {
            this._close()
          }, this.delay), i = e.children(".ui-menu"), i.length && t
      && /^mouse/.test(t.type) && this._startOpening(
          i), this.activeMenu = e.parent(), this._trigger("focus", t, {item: e})
    },
    _scrollIntoView: function (e) {
      var i, s, n, a, o, r;
      this._hasScroll() && (i = parseFloat(
          t.css(this.activeMenu[0], "borderTopWidth")) || 0, s = parseFloat(
          t.css(this.activeMenu[0], "paddingTop")) || 0, n = e.offset().top
          - this.activeMenu.offset().top - i
          - s, a = this.activeMenu.scrollTop(), o = this.activeMenu.height(), r = e.outerHeight(), 0
      > n ? this.activeMenu.scrollTop(a + n) : n + r > o
          && this.activeMenu.scrollTop(a + n - o + r))
    },
    blur: function (t, e) {
      e || clearTimeout(this.timer), this.active && (this.active.removeClass(
          "ui-state-focus"), this.active = null, this._trigger("blur", t,
          {item: this.active}))
    },
    _startOpening: function (t) {
      clearTimeout(this.timer), "true" === t.attr("aria-hidden")
      && (this.timer = this._delay(function () {
        this._close(), this._open(t)
      }, this.delay))
    },
    _open: function (e) {
      var i = t.extend({of: this.active}, this.options.position);
      clearTimeout(this.timer), this.element.find(".ui-menu").not(
          e.parents(".ui-menu")).hide().attr("aria-hidden",
          "true"), e.show().removeAttr("aria-hidden").attr("aria-expanded",
          "true").position(i)
    },
    collapseAll: function (e, i) {
      clearTimeout(this.timer), this.timer = this._delay(function () {
        var s = i ? this.element : t(e && e.target).closest(
            this.element.find(".ui-menu"));
        s.length || (s = this.element), this._close(s), this.blur(
            e), this.activeMenu = s
      }, this.delay)
    },
    _close: function (t) {
      t || (t = this.active ? this.active.parent() : this.element), t.find(
          ".ui-menu").hide().attr("aria-hidden", "true").attr("aria-expanded",
          "false").end().find(".ui-state-active").not(
          ".ui-state-focus").removeClass("ui-state-active")
    },
    _closeOnDocumentClick: function (e) {
      return !t(e.target).closest(".ui-menu").length
    },
    _isDivider: function (t) {
      return !/[^\-\u2014\u2013\s]/.test(t.text())
    },
    collapse: function (t) {
      var e = this.active && this.active.parent().closest(".ui-menu-item",
          this.element);
      e && e.length && (this._close(), this.focus(t, e))
    },
    expand: function (t) {
      var e = this.active && this.active.children(".ui-menu ").find(
          this.options.items).first();
      e && e.length && (this._open(e.parent()), this._delay(function () {
        this.focus(t, e)
      }))
    },
    next: function (t) {
      this._move("next", "first", t)
    },
    previous: function (t) {
      this._move("prev", "last", t)
    },
    isFirstItem: function () {
      return this.active && !this.active.prevAll(".ui-menu-item").length
    },
    isLastItem: function () {
      return this.active && !this.active.nextAll(".ui-menu-item").length
    },
    _move: function (t, e, i) {
      var s;
      this.active && (s = "first" === t || "last" === t ? this.active["first"
      === t ? "prevAll" : "nextAll"](".ui-menu-item").eq(-1) : this.active[t
      + "All"](".ui-menu-item").eq(0)), s && s.length && this.active
      || (s = this.activeMenu.find(this.options.items)[e]()), this.focus(i, s)
    },
    nextPage: function (e) {
      var i, s, n;
      return this.active ? (this.isLastItem() || (this._hasScroll()
          ? (s = this.active.offset().top, n = this.element.height(), this.active.nextAll(
              ".ui-menu-item").each(function () {
            return i = t(this), 0 > i.offset().top - s - n
          }), this.focus(e, i)) : this.focus(e,
              this.activeMenu.find(this.options.items)[this.active ? "last"
                  : "first"]())), void 0) : (this.next(e), void 0)
    },
    previousPage: function (e) {
      var i, s, n;
      return this.active ? (this.isFirstItem() || (this._hasScroll()
          ? (s = this.active.offset().top, n = this.element.height(), this.active.prevAll(
              ".ui-menu-item").each(function () {
            return i = t(this), i.offset().top - s + n > 0
          }), this.focus(e, i)) : this.focus(e,
              this.activeMenu.find(this.options.items).first())), void 0)
          : (this.next(e), void 0)
    },
    _hasScroll: function () {
      return this.element.outerHeight() < this.element.prop("scrollHeight")
    },
    select: function (e) {
      this.active = this.active || t(e.target).closest(".ui-menu-item");
      var i = {item: this.active};
      this.active.has(".ui-menu").length || this.collapseAll(e,
          !0), this._trigger("select", e, i)
    },
    _filterMenuItems: function (e) {
      var i = e.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, "\\$&"),
          s = RegExp("^" + i, "i");
      return this.activeMenu.find(this.options.items).filter(
          ".ui-menu-item").filter(function () {
        return s.test(t.trim(t(this).text()))
      })
    }
  }), t.widget("ui.autocomplete", {
    version: "1.11.4",
    defaultElement: "<input>",
    options: {
      appendTo: null,
      autoFocus: !1,
      delay: 300,
      minLength: 1,
      position: {my: "left top", at: "left bottom", collision: "none"},
      source: null,
      change: null,
      close: null,
      focus: null,
      open: null,
      response: null,
      search: null,
      select: null
    },
    requestIndex: 0,
    pending: 0,
    _create: function () {
      var e, i, s, n = this.element[0].nodeName.toLowerCase(),
          a = "textarea" === n, o = "input" === n;
      this.isMultiLine = a ? !0 : o ? !1 : this.element.prop(
          "isContentEditable"), this.valueMethod = this.element[a || o ? "val"
          : "text"], this.isNewMenu = !0, this.element.addClass(
          "ui-autocomplete-input").attr("autocomplete", "off"), this._on(
          this.element, {
            keydown: function (n) {
              if (this.element.prop(
                  "readOnly")) {
                return e = !0, s = !0, i = !0, void 0;
              }
              e = !1, s = !1, i = !1;
              var a = t.ui.keyCode;
              switch (n.keyCode) {
                case a.PAGE_UP:
                  e = !0, this._move("previousPage", n);
                  break;
                case a.PAGE_DOWN:
                  e = !0, this._move("nextPage", n);
                  break;
                case a.UP:
                  e = !0, this._keyEvent("previous", n);
                  break;
                case a.DOWN:
                  e = !0, this._keyEvent("next", n);
                  break;
                case a.ENTER:
                  this.menu.active
                  && (e = !0, n.preventDefault(), this.menu.select(n));
                  break;
                case a.TAB:
                  this.menu.active && this.menu.select(n);
                  break;
                case a.ESCAPE:
                  this.menu.element.is(":visible") && (this.isMultiLine
                  || this._value(this.term), this.close(n), n.preventDefault());
                  break;
                default:
                  i = !0, this._searchTimeout(n)
              }
            }, keypress: function (s) {
              if (e) {
                return e = !1, (!this.isMultiLine || this.menu.element.is(
                    ":visible")) && s.preventDefault(), void 0;
              }
              if (!i) {
                var n = t.ui.keyCode;
                switch (s.keyCode) {
                  case n.PAGE_UP:
                    this._move("previousPage", s);
                    break;
                  case n.PAGE_DOWN:
                    this._move("nextPage", s);
                    break;
                  case n.UP:
                    this._keyEvent("previous", s);
                    break;
                  case n.DOWN:
                    this._keyEvent("next", s)
                }
              }
            }, input: function (t) {
              return s ? (s = !1, t.preventDefault(), void 0)
                  : (this._searchTimeout(t), void 0)
            }, focus: function () {
              this.selectedItem = null, this.previous = this._value()
            }, blur: function (t) {
              return this.cancelBlur ? (delete this.cancelBlur, void 0)
                  : (clearTimeout(this.searching), this.close(t), this._change(
                      t), void 0)
            }
          }), this._initSource(), this.menu = t("<ul>").addClass(
          "ui-autocomplete ui-front").appendTo(this._appendTo()).menu(
          {role: null}).hide().menu("instance"), this._on(this.menu.element, {
        mousedown: function (e) {
          e.preventDefault(), this.cancelBlur = !0, this._delay(function () {
            delete this.cancelBlur
          });
          var i = this.menu.element[0];
          t(e.target).closest(".ui-menu-item").length || this._delay(
              function () {
                var e = this;
                this.document.one("mousedown", function (s) {
                  s.target === e.element[0] || s.target === i || t.contains(i,
                      s.target) || e.close()
                })
              })
        }, menufocus: function (e, i) {
          var s, n;
          return this.isNewMenu && (this.isNewMenu = !1, e.originalEvent
          && /^mouse/.test(e.originalEvent.type))
              ? (this.menu.blur(), this.document.one("mousemove", function () {
                t(e.target).trigger(e.originalEvent)
              }), void 0) : (n = i.item.data("ui-autocomplete-item"), !1
              !== this._trigger("focus", e, {item: n}) && e.originalEvent
              && /^key/.test(e.originalEvent.type) && this._value(
                  n.value), s = i.item.attr("aria-label") || n.value, s
              && t.trim(s).length && (this.liveRegion.children().hide(), t(
                  "<div>").text(s).appendTo(this.liveRegion)), void 0)
        }, menuselect: function (t, e) {
          var i = e.item.data("ui-autocomplete-item"), s = this.previous;
          this.element[0] !== this.document[0].activeElement
          && (this.element.focus(), this.previous = s, this._delay(function () {
            this.previous = s, this.selectedItem = i
          })), !1 !== this._trigger("select", t, {item: i}) && this._value(
              i.value), this.term = this._value(), this.close(
              t), this.selectedItem = i
        }
      }), this.liveRegion = t("<span>", {
        role: "status",
        "aria-live": "assertive",
        "aria-relevant": "additions"
      }).addClass("ui-helper-hidden-accessible").appendTo(
          this.document[0].body), this._on(this.window, {
        beforeunload: function () {
          this.element.removeAttr("autocomplete")
        }
      })
    },
    _destroy: function () {
      clearTimeout(this.searching), this.element.removeClass(
          "ui-autocomplete-input").removeAttr(
          "autocomplete"), this.menu.element.remove(), this.liveRegion.remove()
    },
    _setOption: function (t, e) {
      this._super(t, e), "source" === t && this._initSource(), "appendTo" === t
      && this.menu.element.appendTo(this._appendTo()), "disabled" === t && e
      && this.xhr && this.xhr.abort()
    },
    _appendTo: function () {
      var e = this.options.appendTo;
      return e && (e = e.jquery || e.nodeType ? t(e) : this.document.find(e).eq(
          0)), e && e[0] || (e = this.element.closest(".ui-front")), e.length
      || (e = this.document[0].body), e
    },
    _initSource: function () {
      var e, i, s = this;
      t.isArray(this.options.source)
          ? (e = this.options.source, this.source = function (i, s) {
            s(t.ui.autocomplete.filter(e, i.term))
          }) : "string" == typeof this.options.source
          ? (i = this.options.source, this.source = function (e, n) {
            s.xhr && s.xhr.abort(), s.xhr = t.ajax({
              url: i, data: e, dataType: "json", success: function (t) {
                n(t)
              }, error: function () {
                n([])
              }
            })
          }) : this.source = this.options.source
    },
    _searchTimeout: function (t) {
      clearTimeout(this.searching), this.searching = this._delay(function () {
        var e = this.term === this._value(),
            i = this.menu.element.is(":visible"),
            s = t.altKey || t.ctrlKey || t.metaKey || t.shiftKey;
        (!e || e && !i && !s) && (this.selectedItem = null, this.search(null,
            t))
      }, this.options.delay)
    },
    search: function (t, e) {
      return t = null != t ? t
          : this._value(), this.term = this._value(), t.length
      < this.options.minLength ? this.close(e) : this._trigger("search", e)
      !== !1 ? this._search(t) : void 0
    },
    _search: function (t) {
      this.pending++, this.element.addClass(
          "ui-autocomplete-loading"), this.cancelSearch = !1, this.source(
          {term: t}, this._response())
    },
    _response: function () {
      var e = ++this.requestIndex;
      return t.proxy(function (t) {
        e === this.requestIndex && this.__response(
            t), this.pending--, this.pending || this.element.removeClass(
            "ui-autocomplete-loading")
      }, this)
    },
    __response: function (t) {
      t && (t = this._normalize(t)), this._trigger("response", null,
          {content: t}), !this.options.disabled && t && t.length
      && !this.cancelSearch ? (this._suggest(t), this._trigger("open"))
          : this._close()
    },
    close: function (t) {
      this.cancelSearch = !0, this._close(t)
    },
    _close: function (t) {
      this.menu.element.is(":visible")
      && (this.menu.element.hide(), this.menu.blur(), this.isNewMenu = !0, this._trigger(
          "close", t))
    },
    _change: function (t) {
      this.previous !== this._value() && this._trigger("change", t,
          {item: this.selectedItem})
    },
    _normalize: function (e) {
      return e.length && e[0].label && e[0].value ? e : t.map(e, function (e) {
        return "string" == typeof e ? {label: e, value: e} : t.extend({}, e,
            {label: e.label || e.value, value: e.value || e.label})
      })
    },
    _suggest: function (e) {
      var i = this.menu.element.empty();
      this._renderMenu(i,
          e), this.isNewMenu = !0, this.menu.refresh(), i.show(), this._resizeMenu(), i.position(
          t.extend({of: this.element},
              this.options.position)), this.options.autoFocus
      && this.menu.next()
    },
    _resizeMenu: function () {
      var t = this.menu.element;
      t.outerWidth(
          Math.max(t.width("").outerWidth() + 1, this.element.outerWidth()))
    },
    _renderMenu: function (e, i) {
      var s = this;
      t.each(i, function (t, i) {
        s._renderItemData(e, i)
      })
    },
    _renderItemData: function (t, e) {
      return this._renderItem(t, e).data("ui-autocomplete-item", e)
    },
    _renderItem: function (e, i) {
      return t("<li>").text(i.label).appendTo(e)
    },
    _move: function (t, e) {
      return this.menu.element.is(":visible") ? this.menu.isFirstItem()
          && /^previous/.test(t) || this.menu.isLastItem() && /^next/.test(t)
          ? (this.isMultiLine || this._value(
              this.term), this.menu.blur(), void 0) : (this.menu[t](e), void 0)
          : (this.search(null, e), void 0)
    },
    widget: function () {
      return this.menu.element
    },
    _value: function () {
      return this.valueMethod.apply(this.element, arguments)
    },
    _keyEvent: function (t, e) {
      (!this.isMultiLine || this.menu.element.is(":visible")) && (this._move(t,
          e), e.preventDefault())
    }
  }), t.extend(t.ui.autocomplete, {
    escapeRegex: function (t) {
      return t.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, "\\$&")
    }, filter: function (e, i) {
      var s = RegExp(t.ui.autocomplete.escapeRegex(i), "i");
      return t.grep(e, function (t) {
        return s.test(t.label || t.value || t)
      })
    }
  }), t.widget("ui.autocomplete", t.ui.autocomplete, {
    options: {
      messages: {
        noResults: "No search results.",
        results: function (t) {
          return t + (t > 1 ? " results are" : " result is")
              + " available, use up and down arrow keys to navigate."
        }
      }
    }, __response: function (e) {
      var i;
      this._superApply(arguments), this.options.disabled || this.cancelSearch
      || (i = e && e.length ? this.options.messages.results(e.length)
          : this.options.messages.noResults, this.liveRegion.children().hide(), t(
          "<div>").text(i).appendTo(this.liveRegion))
    }
  }), t.ui.autocomplete
});