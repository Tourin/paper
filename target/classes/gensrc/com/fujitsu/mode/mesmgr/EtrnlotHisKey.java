package com.fujitsu.mode.mesmgr;

public class EtrnlotHisKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MESMGR.ETRNLOTHIS.LOT_NO
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    private String lotNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MESMGR.ETRNLOTHIS.TRANSACTION_ID
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    private String transactionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MESMGR.ETRNLOTHIS.LOT_NO
     *
     * @return the value of MESMGR.ETRNLOTHIS.LOT_NO
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MESMGR.ETRNLOTHIS.LOT_NO
     *
     * @param lotNo the value for MESMGR.ETRNLOTHIS.LOT_NO
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo == null ? null : lotNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MESMGR.ETRNLOTHIS.TRANSACTION_ID
     *
     * @return the value of MESMGR.ETRNLOTHIS.TRANSACTION_ID
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MESMGR.ETRNLOTHIS.TRANSACTION_ID
     *
     * @param transactionId the value for MESMGR.ETRNLOTHIS.TRANSACTION_ID
     *
     * @mbggenerated Thu Feb 04 16:18:41 CST 2016
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }
}