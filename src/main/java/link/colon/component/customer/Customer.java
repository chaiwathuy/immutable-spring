/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.component.customer;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * @author Peerapat A on Aug 8, 2019
 */
@Builder
@RequiredArgsConstructor
public class Customer {

    public final Long id;
    public final String name;

}
