package com.mkyong.common.user.mail;

import com.mkyong.common.user.EmailServiceTokenModel;

/**
 *
 * @version 1.0
 * @author: Iain Porter iain.porter@porterhead.com
 * @since 13/09/2012
 */
public interface MailSenderService {

    public EmailServiceTokenModel sendVerificationEmail(EmailServiceTokenModel emailServiceTokenModel);

    public EmailServiceTokenModel sendRegistrationEmail(EmailServiceTokenModel emailServiceTokenModel);

    public EmailServiceTokenModel sendLostPasswordEmail(EmailServiceTokenModel emailServiceTokenModel);


}
