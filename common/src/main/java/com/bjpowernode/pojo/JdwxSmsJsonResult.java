package com.bjpowernode.pojo;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
public class JdwxSmsJsonResult {
    /**
     * code : 10000
     * charge : false
     * remain : 1305
     * msg : 查询成功
     * result : {"ReturnStatus":"Success","Message":"ok","RemainPoint":420842,"TaskID":18424321,"SuccessCounts":1}
     */

    /*
 {
    "code": "10000",
    "charge": false,
    "remain": 1305,
    "msg": "查询成功",
    "result": {
        "ReturnStatus": "Success",
        "Message": "ok",
        "RemainPoint": 420842,
        "TaskID": 18424321,
        "SuccessCounts": 1
    }
}
    * */

    private String code;
    private boolean charge;
    private int remain;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * ReturnStatus : Success
         * Message : ok
         * RemainPoint : 420842
         * TaskID : 18424321
         * SuccessCounts : 1
         */

        private String ReturnStatus;
        private String Message;
        private int RemainPoint;
        private int TaskID;
        private int SuccessCounts;

        public String getReturnStatus() {
            return ReturnStatus;
        }

        public void setReturnStatus(String ReturnStatus) {
            this.ReturnStatus = ReturnStatus;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }

        public int getRemainPoint() {
            return RemainPoint;
        }

        public void setRemainPoint(int RemainPoint) {
            this.RemainPoint = RemainPoint;
        }

        public int getTaskID() {
            return TaskID;
        }

        public void setTaskID(int TaskID) {
            this.TaskID = TaskID;
        }

        public int getSuccessCounts() {
            return SuccessCounts;
        }

        public void setSuccessCounts(int SuccessCounts) {
            this.SuccessCounts = SuccessCounts;
        }
    }


}
