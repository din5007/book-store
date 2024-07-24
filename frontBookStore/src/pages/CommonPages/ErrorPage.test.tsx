import { customRender as render } from '../../utils/test-helper';
import ErrorPage from "./ErrorPage"
import { describe, expect, it } from 'vitest';

describe('Error Page', () => {
    it('Error Page should load properly - snapshot', async () => {
        const {container}  = render(<ErrorPage variant='danger' children={'error found'} />);
        expect(container).toMatchSnapshot();
    });
})